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

### Sorting Function:
- How to sorting in Array (e.g. Array<IntArray> xx) - xx.sortWith(compareBy<IntArray>{it[0]}.thenByDescending{it[1]})
- Another way to do by using sortBy it's subarray sum  xx.sortBy { it.sum() }
- How to sort mutable list xx.sort()/xx.sortDescending()/xx.sortBy{}/xx.sortByDescending{}/xx.sortWith()/xx.sorted()/xx.sortedDescending()
- How to sort immutable list xx.sortWith()/xx.sorted()/xx.sortedDescending()/xx.sortedBy{}/xx.sortedByDescending{}

### Range Function:
- 1..9 -> loop will iterate from 1 to 9<br />
- 1 until 9 -> loop will iterate from 1 to 8<br /> 
- 9 downTo 1 -> loop will iterate from 9 to 1<br />

### Collection
- HashMap, TreeMap, LinkedListMap implements MutableMap interface. Where HashMap doesn't maintain order, LinkedListMap maintains insertion order and tree map maintains sorted order 

### Kotlin Co Routine
- In Kotlin, a coroutine is a concurrency design pattern that you can use on the JVM to simplify code that executes asynchronously. Coroutines are a powerful feature that allows you to write asynchronous, non-blocking code in a sequential style, making it easier to read and maintain.
- In co-routine dispatcher manages the thread when need to create new thread or when need to use existing thread from the shared thread pool
- Netty is an open-source, asynchronous event-driven network application framework for rapid development of maintainable high-performance protocol servers and clients. In ktor it is being used an enginer for the server.

### Thread safety way
- @Synchronized to make method synchronize
- To synchronize the collection use Java.Util.Collection.SynchronizedList(listOf()), for map SynchronizedMap
- To iterate the shared list, use synchronized(lst){ do things}

### Kotlin Scope function
- let - this is for to check the null and do some operation on the object


