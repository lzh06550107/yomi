package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmSignMapper;
import cn.liaozh.pojo.YmCarouselFigure;
import cn.liaozh.pojo.YmSign;
import cn.liaozh.service.service.YmCarouselFigureService;
import cn.liaozh.service.service.YmSignService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;

@Service
public class YmSignServiceImpl extends MPJBaseServiceImpl<YmSignMapper, YmSign> implements YmSignService {
    private static final String THREEIMAGE = "";
    private static final String TWOIMAGE = "";
    private static final String ONEIMAGE = "";
    @Autowired
    private YmCarouselFigureService ymCarouselFigureService;

    public YmSign findSignListById(String signId) {
        QueryWrapper<YmSign> wrapper = new QueryWrapper();
        wrapper.eq("sign_id", signId);
        return this.baseMapper.selectOne(wrapper);
    }

    public YmSign findSignListByUserId(String userId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = dateFormat.format(new Date());
        QueryWrapper<YmSign> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sign_in_date", todayStr).eq("user_id", userId);
        YmSign ymSign = this.baseMapper.selectOne(queryWrapper);
        return ymSign == null ? new YmSign() : this.baseMapper.selectOne(queryWrapper);
    }

    public void postSignIn(String userId) {
        YmSign signListByUserId = this.findSignListByUserId(userId);
        if (!userId.equals(signListByUserId.getUserId())) {
            Date today = new Date();
            YmSign sign = new YmSign();
            sign.setUserId(userId);
            sign.setSignInDate(today);
            this.baseMapper.insert(sign);
        }
    }

    public YmSign findSignByUserId(String userId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = dateFormat.format(new Date());
        QueryWrapper<YmSign> wrapper = new QueryWrapper<>();
        wrapper.like("sign_in_date", todayStr);
        YmSign ymSign = this.baseMapper.selectOne(wrapper);
        return ymSign;
    }

    public YmSign IsTime(String userId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = now.with(LocalTime.MAX);
        LocalDateTime startOfDay = now.with(LocalTime.MIN);
        LocalDateTime fifthMinute = startOfDay.withMinute(5).withSecond(0).withNano(0).plusSeconds(1L);
        LocalDateTime lastMinute = endOfDay.withMinute(59).withSecond(59).withNano(999999999);
        QueryWrapper<YmSign> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).gt("sign_in_date", fifthMinute).lt("sign_in_date", lastMinute);
        YmSign one = this.baseMapper.selectOne(queryWrapper);
        return one;
    }

    public YmSign findSignCount(String userId) {
        QueryWrapper<YmSign> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        Integer integer = this.baseMapper.selectCount(wrapper);
        YmSign ymSign = new YmSign();
        ymSign.setNeedDay(15);
        ymSign.setUserSignCount(integer);
        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        HashMap<String, String> hashMapOne = new HashMap<>();
        map.put("5", hashMapOne);
        hashMapOne.put("shopName", "快递刀");
        hashMapOne.put("img", "https://campus.change.tm/api/img/2023/06/19/c0314f39baa749808fdab664063198dfsab0BGoXVw6G2e883c8433ae6e96f41b6be31ceabcdf.png");
        HashMap<String, String> hashMapTwo = new HashMap<>();
        hashMapTwo.put("shopName", "台灯");
        hashMapTwo.put("img", "https://campus.change.tm/api/img/2023/06/19/02a1c133f79448db8c71b44601540242ksAmhclTgOETd25e5aa2b7b6d7e7c13fcb498f5411c4.png");
        map.put("10", hashMapTwo);
        HashMap<String, String> hashMapThree = new HashMap<>();
        hashMapThree.put("shopName", "CSDN T恤");
        hashMapThree.put("img", "https://campus.change.tm/api/img/2023/06/20/8678017b7773465d9f35a81602713598ZPJ3HdcqjlHQ64eecf33f91f50eae4de7622bdc7d447.png");
        map.put("15", hashMapThree);
        ymSign.setItems(map);
        ymSign.setIndexImg("https://campus.change.tm/api/img/2023/06/19/a8a07b94f2e14c8cbc25568cbd967beaDIeAzyNI5TbY5fed43b419d8afda32682060a1f59550.png");
        LambdaQueryWrapper<YmCarouselFigure> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(YmCarouselFigure::getType, 1);
        YmCarouselFigure entity = this.ymCarouselFigureService.getOne(lambdaQueryWrapper);
        ymSign.setYmCarouselFigure(entity);
        YmSign one = this.IsTime(userId);
        if (one != null) {
            ymSign.setIsSign(1);
        } else {
            ymSign.setIsSign(0);
        }

        return ymSign;
    }
}
