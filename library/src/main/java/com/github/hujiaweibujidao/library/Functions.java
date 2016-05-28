package com.github.hujiaweibujidao.library;


/**
 * 工具类，将自定义的函数快速封装成BaseFunction
 */
class Functions {

    private static IFunction function;

    public static BaseFunction with(final IFunction function) {
        return new BaseFunction() {
            @Override
            public float getValue(float input) {
                return function.getValue(input);
            }
        };
    }

}
