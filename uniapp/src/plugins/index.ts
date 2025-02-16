import { isFunction } from '@vue/shared'
import type { App } from 'vue'
const modules = import.meta.glob('./modules/**/*.ts', { eager: true})
// console.log(modules);
export default {
    // install 方法是 Vue 插件的标准入口，接收 app 实例作为参数
    install: (app: App) => {
        for (const module of Object.values(modules)) {
            try {
                const fun = (module as { default: Function }).default;
                isFunction(fun) && fun(app)
            } catch (error) {
                console.error('Failed to load module:', error);
            }
        }
    }
}
