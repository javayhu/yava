package com.github.hujiaweibujidao.library;

import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;


/**
 * 常见的30个缓动函数的实现
 *
 * @author hujiawei 16/5/27
 */
public enum EasingFunction implements IFunction, Interpolator, TypeEvaluator<Float> {

    /* ------------------------------------------------------------------------------------------- */
    /* BACK
    /* ------------------------------------------------------------------------------------------- */
    BACK_IN {
        @Override
        public float getValue(float input) {
            return input * input * ((1.70158f + 1) * input - 1.70158f);
        }
    },
    BACK_OUT {
        @Override
        public float getValue(float input) {
            return ((input = input - 1) * input * ((1.70158f + 1) * input + 1.70158f) + 1);
        }
    },
    BACK_INOUT {
        @Override
        public float getValue(float input) {
            float s = 1.70158f;
            if ((input *= 2) < 1) {
                return 0.5f * (input * input * (((s *= (1.525f)) + 1) * input - s));
            }
            return 0.5f * ((input -= 2) * input * (((s *= (1.525f)) + 1) * input + s) + 2);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* BOUNCE
    /* ------------------------------------------------------------------------------------------- */
    BOUNCE_IN {
        @Override
        public float getValue(float input) {
            input = 1 - input;
            if (input < (1 / 2.75))
                return 1 - (7.5625f * input * input);
            else if (input < (2 / 2.75))
                return 1 - (7.5625f * (input -= (1.5f / 2.75f)) * input + 0.75f);
            else if (input < (2.5 / 2.75))
                return 1 - (7.5625f * (input -= (2.25f / 2.75f)) * input + 0.9375f);
            else
                return 1 - (7.5625f * (input -= (2.625f / 2.75f)) * input + 0.984375f);
        }
    },
    BOUNCE_OUT {
        @Override
        public float getValue(float input) {
            if (input < (1 / 2.75))
                return (7.5625f * input * input);
            else if (input < (2 / 2.75))
                return (7.5625f * (input -= (1.5f / 2.75f)) * input + 0.75f);
            else if (input < (2.5 / 2.75))
                return (7.5625f * (input -= (2.25f / 2.75f)) * input + 0.9375f);
            else
                return (7.5625f * (input -= (2.625f / 2.75f)) * input + 0.984375f);
        }
    },
    BOUNCE_INOUT {
        @Override
        public float getValue(float input) {
            if ((input) < 0.5f) {
                input = input * 2;
                input = 1 - input;
                if (input < (1 / 2.75))
                    return (1 - (7.5625f * input * input)) * 0.5f;
                else if (input < (2 / 2.75))
                    return (1 - (7.5625f * (input -= (1.5f / 2.75f)) * input + 0.75f)) * 0.5f;
                else if (input < (2.5 / 2.75))
                    return (1 - (7.5625f * (input -= (2.25f / 2.75f)) * input + 0.9375f)) * 0.5f;
                else
                    return (1 - (7.5625f * (input -= (2.625f / 2.75f)) * input + 0.984375f)) * 0.5f;
            } else {
                input = input * 2 - 1;
                if (input < (1 / 2.75))
                    return ((7.5625f * input * input)) * 0.5f + 1 * 0.5f;
                else if (input < (2 / 2.75))
                    return ((7.5625f * (input -= (1.5f / 2.75f)) * input + 0.75f)) * 0.5f + 1 * 0.5f;
                else if (input < (2.5 / 2.75))
                    return ((7.5625f * (input -= (2.25f / 2.75f)) * input + 0.9375f)) * 0.5f + 1 * 0.5f;
                else
                    return ((7.5625f * (input -= (2.625f / 2.75f)) * input + 0.984375f)) * 0.5f + 1 * 0.5f;
            }
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* CIRCULAR
    /* ------------------------------------------------------------------------------------------- */
    CIRCULAR_IN {
        @Override
        public float getValue(float input) {
            return (float) (-1 * (Math.sqrt(1 - input * input) - 1.0f));
        }
    },
    CIRCULAR_OUT {
        @Override
        public float getValue(float input) {
            return (float) (Math.sqrt(1 - (input - 1) * (input - 1)));
        }
    },
    CIRCULAR_INOUT {
        @Override
        public float getValue(float input) {
            if ((input /= 0.5) < 1) {
                return (float) (-1 * 0.5 * (Math.sqrt(1 - input * input) - 1));
            }
            return (float) (0.5 * (Math.sqrt(1 - (input -= 2) * input) + 1));
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* ELASTIC //todo duration 3
    /* ------------------------------------------------------------------------------------------- */
    ELASTIC_IN {
        @Override
        public float getValue(float input) {
            float mDuration = getDuration() / 1000f;
            float s;
            float p = 0.0f;
            float a = 0.0f;
            if (input == 0) {
                return 0;
            }
            if (input == 1) {
                return 1;
            }
            if (p == 0) {
                p = mDuration * 0.3f;
            }
            if (a == 0 || (1 > 0 && a < 1) || (1 < 0 /*&& a < -1*/)) {
                a = 1;
                s = p / 4;
            } else {
                s = (float) (p / TWO_PI * Math.asin(1 / a));
            }
            return (float) (-(a * Math.pow(2, 10 * (input -= 1)) * Math.sin((input * mDuration - s) * TWO_PI / p)) + 0);
        }
    },
    ELASTIC_OUT {
        @Override
        public float getValue(float input) {
            float mDuration = getDuration() / 1000f;
            float s;
            float p = 0.0f;
            float a = 0.0f;
            if (input == 0) {
                return 0;
            }
            if (input == 1) {
                return 1;
            }
            if (p == 0) {
                p = mDuration * 0.3f;
            }
            if (a == 0 || (1 > 0 && a < 1) || (1 < 0 /*&& a < -1*/)) {
                a = 1;
                s = p / 4;
            } else {
                s = (float) (p / TWO_PI * Math.asin(1 / a));
            }
            return (float) (a * Math.pow(2, -10 * input) * Math.sin((input * mDuration - s) * TWO_PI / p) + 1 + 0);
        }
    },
    ELASTIC_INOUT {
        @Override
        public float getValue(float input) {
            float mDuration = getDuration() / 1000f;
            float s;
            float p = 0.0f;
            float a = 0.0f;
            if (input == 0) {
                return 0;
            }
            if ((input /= 0.5) == 2) {
                return 1;
            }
            if (p == 0) {
                p = mDuration * (0.3f * 1.5f);
            }
            if (a == 0 || (1 > 0 && a < 1) || (1 < 0 /*&& a < -1*/)) {
                a = 1;
                s = p / 4;
            } else {
                s = (float) (p / TWO_PI * Math.asin(1 / a));
            }
            if (input < 1) {
                return (float) (-0.5 * (a * Math.pow(2, 10 * (input -= 1)) * Math.sin((input * mDuration - s) * TWO_PI / p)) + 0);
            }
            return (float) (a * Math.pow(2, -10 * (input -= 1)) * Math.sin((input * mDuration - s) * TWO_PI / p) * .5 + 1 + 0);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* EXPO
    /* ------------------------------------------------------------------------------------------- */
    EXPO_IN {
        @Override
        public float getValue(float input) {
            return (float) ((input == 0) ? 0 : 1 * Math.pow(2, 10 * (input - 1)) - 0.001f);
        }
    },
    EXPO_OUT {
        @Override
        public float getValue(float input) {
            return (float) ((input == 1) ? 1 : (-Math.pow(2, -10 * input) + 1));
        }
    },
    EXPO_INOUT {
        @Override
        public float getValue(float input) {
            if (input == 0) {
                return 0;
            }
            if (input == 1) {
                return 1;
            }
            if ((input /= 0.5f) < 1) {
                return (float) (0.5f * Math.pow(2, 10 * (input - 1)));
            }
            return (float) (0.5f * (-Math.pow(2, -10 * --input) + 2));
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* QUAD
    /* ------------------------------------------------------------------------------------------- */
    QUAD_IN {
        @Override
        public float getValue(float input) {
            return input * input;
        }
    },
    QUAD_OUT {
        @Override
        public float getValue(float input) {
            return -input * (input - 2);
        }
    },
    QUAD_INOUT {
        @Override
        public float getValue(float input) {
            if ((input /= 0.5f) < 1) {
                return 0.5f * input * input;
            }
            return -0.5f * ((--input) * (input - 2) - 1);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* CUBIC
    /* ------------------------------------------------------------------------------------------- */
    CUBIC_IN {
        @Override
        public float getValue(float input) {
            return input * input * input;
        }
    },
    CUBIC_OUT {
        @Override
        public float getValue(float input) {
            return (input - 1) * (input - 1) * (input - 1) + 1;
        }
    },
    CUBIC_INOUT {
        @Override
        public float getValue(float input) {
            if ((input /= 0.5f) < 1) {
                return 0.5f * input * input * input;
            }
            return 0.5f * ((input -= 2) * input * input + 2);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* QUART
    /* ------------------------------------------------------------------------------------------- */
    QUART_IN {
        @Override
        public float getValue(float input) {
            return input * input * input * input;
        }
    },
    QUART_OUT {
        @Override
        public float getValue(float input) {
            return 1 - (input - 1) * (input - 1) * (input - 1) * (input - 1);
        }
    },
    QUART_INOUT {
        @Override
        public float getValue(float input) {
            if ((input /= 0.5f) < 1) {
                return 0.5f * input * input * input * input;
            }
            return -0.5f * ((input -= 2) * input * input * input - 2);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* QUINT
    /* ------------------------------------------------------------------------------------------- */
    QUINT_IN {
        @Override
        public float getValue(float input) {
            return input * input * input * input * input;
        }
    },
    QUINT_OUT {
        @Override
        public float getValue(float input) {
            return (input - 1) * (input - 1) * (input - 1) * (input - 1) * (input - 1) + 1;
        }
    },
    QUINT_INOUT {
        @Override
        public float getValue(float input) {
            if ((input /= 0.5f) < 1) {
                return 0.5f * input * input * input * input * input;
            }
            return 0.5f * ((input -= 2) * input * input * input * input + 2);
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* SINE
    /* ------------------------------------------------------------------------------------------- */
    SINE_IN {
        @Override
        public float getValue(float input) {
            return (float) (-1 * Math.cos(input * HALF_PI) + 1);
        }
    },
    SINE_OUT {
        @Override
        public float getValue(float input) {
            return (float) Math.sin(input * HALF_PI);
        }
    },
    SINE_INOUT {
        @Override
        public float getValue(float input) {
            return (float) (-1 * 0.5f * (Math.cos(PI * input) - 1));
        }
    },

    /* ------------------------------------------------------------------------------------------- */
    /* BREATH
    /* ------------------------------------------------------------------------------------------- */
    BREATH {
        @Override
        public float getValue(float input) {
            if (input < 0.333) {
                return (float) (0.5f + 0.5f * Math.sin(input * 3.0f * Math.PI - Math.PI * 0.5f));
            } else {
                return (float) Math.pow((0.5 * Math.sin(-3f * Math.PI * input * 0.5f + Math.PI) + 0.5f), 2);
            }
        }
    };

    //如果这个function在求值的时候需要duration作为参数的话，那么可以通过setDuration来设置，否则使用默认值
    private float duration = 1000f;//目前只有ELASTIC***这三个是需要duration的，其他的都不需要

    public float getDuration() {
        return duration;
    }

    public EasingFunction setDuration(float duration) {
        this.duration = duration;
        return this;
    }

    //将Function当做Interpolator使用，默认的实现，不需要枚举元素去重新实现
    @Override
    public float getInterpolation(float input) {
        return getValue(input);
    }

    //将Function当做TypeEvaluator使用，默认的实现，不需要枚举元素去重新实现
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        return startValue + getValue(fraction) * (endValue - startValue);
    }

    //几个数学常量
    public static final float PI = (float) Math.PI;
    public static float TWO_PI = PI * 2.0f;
    public static float HALF_PI = PI * 0.5f;
}
