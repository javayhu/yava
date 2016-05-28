package com.github.hujiaweibujidao.library;


/**
 * 工具类，将自定义的函数快速封装成AbstractFunction
 */
class Functions {
    private static IFunction function;

    public static AbstractFunction with(final IFunction function) {
        return new AbstractFunction() {
            @Override
            public float getValue(float input) {
                return function.getValue(input);
            }
        };
    }
}
