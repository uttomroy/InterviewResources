### Required function for String processing
- length -> to return the length of the string<br /> 
- split(" ") -> split the string base on given delimeter<br /> 
- joinToString("") -> Join the list elements by given delimeter<br />
- trim()
- replace("x", "y")
- substring(startIndex, size)
- toUpperCase()
- toLowerCase()
- startsWith("")
- endsWith("")
- indexOf("")
- lastIndexOf("")
- contains("")

### Range Function:
- 1..9 -> loop will iterate from 1 to 9<br /> 
- 9 downTo 1 -> loop will iterate from 9 to 1<br />

### Kotlin Co Routine
- In Kotlin, a coroutine is a concurrency design pattern that you can use on the JVM to simplify code that executes asynchronously. Coroutines are a powerful feature that allows you to write asynchronous, non-blocking code in a sequential style, making it easier to read and maintain.
- In co-routine dispatcher manages the thread when need to create new thread or when need to use existing thread from the shared thread pool
- Netty is an open-source, asynchronous event-driven network application framework for rapid development of maintainable high-performance protocol servers and clients. In ktor it is being used an enginer for the server.

### Thread safety way
- @Synchronized to make method synchronize
- To synchronize the collection use Java.Util.Collection.SynchronizedList(listOf()), for map SynchronizedMap
- To iterate the shared list, use synchronized(lst){ do things}


