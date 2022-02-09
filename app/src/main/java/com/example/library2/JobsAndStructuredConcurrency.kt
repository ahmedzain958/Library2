package com.example.library2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //------------------------------------------------------
    //the next all between curly braces is called coroutine builder
    GlobalScope.launch {//parent job: if cancelled all the children will be cancelled
        launch { launch { }/*child of child1*/ }//child 1 job : both launch are coroutines not suspend functions
        launch { }//child 2 job : both launch are coroutines not suspend functions
    }
    //Note: if any child failed all, the Parent job will be cancelled - beside parent job will not be completed until all the
    //children are completed
    //------------------------------------------------------
    /*Structured Concurrency: relationships between coroutines in-which one depends on the other and another one
    is a child of the other, and one can't work until the other completes
    ma2bad w no2at bedaya w no2at nehaya w de ma te9lash 2abl d- w te mo3tameda 3la d
    w d if cancelled all before will be cancelled as well*/
    //------------------------------------------------------
    //job cancellation method 1
    val job1: Job = GlobalScope.launch {
        launch { getUserFromNetwork() }
        launch { getUserFromDB() }
    }
    //if we called job.cancel() it will cancel all the children jobs beside if any child failed, it will fail the other child
    job1.cancel()
    //------------------------------------------------------
    //job cancellation method 2
    val parentJob : Job = Job()
    //then I will make childToParent child to the parentJob
    val childToParent: Job = GlobalScope.launch(parentJob) {
        launch { getUserFromNetwork() }//child to the childToParent which is child to parentJob
        launch { getUserFromDB() }//child to the childToParent which is child to parentJob
    }
    parentJob.cancel()// cancels childToParent and its children
    //------------------------------------------------------
}

private suspend fun getUserFromDB(): String {
    delay(1000)
    return "Aly"
}

private suspend fun getUserFromNetwork(): String {
    delay(2000)
    return "Aly"
}
