### JNI创建线程

在使用JNI创建线程之前，我们先来说下JNI是什么？JNI是Java Native Interface 的缩写，它可以允许Java代码与其他语言写的代码进行交互，尤其是C和C++（~~这段百度抄的~~）。JNI框架允许Native方法调用JAVA对象。

**使用JNI创建线程，可以使用跟C/C++同样的方式吗？**

可以！只要你的线程不需要跟Java代码做交互。当C++代码与Java代码有了交互，就不可避免地牵扯到Java跟C++的不同点，比如虚拟机，类加载机制，基本数据类型等等。

**那么可以不使用JNI创建，使用Java创建线程启动JNI代码吗？**

也可以！主要根据业务类型来取舍，可以肯定的是绕一大圈创建线程以及进行线程间数据传递绝对是很痛苦的事。

**进入正题**

当JVM调用native方法，就会传递一个JNIEnv指针，一个jobject指针。JNIEnv* 可以让native方法与JNI环境交互， 但是仅在当前线程有效。其他线程必须先调用AttacheCurrentThread() 把自身附加到虚拟机环境来获得JNIEnv * 。线程执行DetachCurrentThread() 把自身脱离虚拟机。

```c++
/*线程附加到虚拟机并获得JNIEnv指针*/
JNIEnv *env;
(*g_vm)->AttachCurrentThread (g_vm, (void **) &env, NULL);
```

```c++
/*线程脱离虚拟机*/
(*g_vm)->DetachCurrentThread (g_vm);
```

另外还有自动Detach的函数

```c++
(*g_vm)->AttachCurrentThreadAsDaemon (g_vm, (void **) &env, NULL);
```

上面代码中(*g_vm)是一个JavaVM的指针，JavaVM是虚拟机的代表，一个进程中只能有一个虚拟机，所有线程共用一个虚拟机。所以我们首先要在JavaVM调用native方法的时候讲这个指针存下来。

```C++
(*env).GetJavaVM(&g_vm);
```

Unloading JavaVM ：暂时没用过

```C++
(*g_vm).DestroyJavaVM();
```

另外还有注意的是不要在一个线程里多次Attach/Detach，会产生内存泄漏

