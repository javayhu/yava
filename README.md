
## Yava

> Yet Another View Animation ( a simple and elegant view animation library for Android)


关于本项目的创建缘由以及实现思路请参见我的这三篇文章

[当数学遇上动画：讲述`ValueAnimator`、`TypeEvaluator`和`TimeInterpolator`之间的恩恩怨怨(1)](http://hujiaweibujidao.github.io/blog/2016/05/26/when-math-meets-android-animation/)    
[当数学遇上动画：讲述`ValueAnimator`、`TypeEvaluator`和`TimeInterpolator`之间的恩恩怨怨(2)](http://hujiaweibujidao.github.io/blog/2016/05/27/When-Math-meets-Android-Animation-2/)     
[当数学遇上动画：讲述`ValueAnimator`、`TypeEvaluator`和`TimeInterpolator`之间的恩恩怨怨(3)](http://hujiaweibujidao.github.io/blog/2016/05/27/When-Math-meets-Android-Animation-3/)     

## Screenshot

![img](yava.gif)

## Usage

举个例子，以弹跳动画效果为例，可以直接使用`EasingFunction.BOUNCE_OUT`作为`Interpolator`或者`TypeEvaluator`来使用：

第一种方式：使用线性插值器和自定义的TypeEvaluator
```
ObjectAnimator animator1 = new ObjectAnimator();
animator1.setTarget(textView1);
animator1.setPropertyName("translationY");
animator1.setFloatValues(0f, -100f);
animator1.setDuration(1000);
animator1.setInterpolator(new LinearInterpolator());
animator1.setEvaluator(EasingFunction.BOUNCE_OUT); //这里将EasingFunction.BOUNCE_OUT作为TypeEvaluator来使用
animator1.start();
```

第二种方式：使用自定义的Interpolator和"线性估值器"
```
ObjectAnimator animator2 = new ObjectAnimator();
animator2.setTarget(textView2);
animator2.setPropertyName("translationY");
animator2.setFloatValues(0f, -100f);
animator2.setDuration(1000);
animator2.setInterpolator(EasingFunction.BOUNCE_OUT); //这里将EasingFunction.BOUNCE_OUT作为Interpolator来使用
animator2.setEvaluator(new FloatEvaluator());
animator2.start();
```

## Reference

本项目主要参考了以下项目和内容    
1.[EaseInterpolator](https://github.com/cimi-chen/EaseInterpolator)    
2.[AnimationEasingFunctions](https://github.com/daimajia/AnimationEasingFunctions)       
3.[easings.net](http://easings.net/)     

## License

```
The MIT License (MIT)

Copyright (c) 2016 Hujiawei

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```