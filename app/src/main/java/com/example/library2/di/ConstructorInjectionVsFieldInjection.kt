package com.example.library2.di

object DependencyContainer {
    val repository = Repository()
}
/**
 * Field Injection: is the technique of having dependencies declared as variables, providing instances through a container
 * field injection disadvantages:
 * - view model is tightly coupled to DependencyContainer and we can't use view model without it.
 * - in testing when you take an instance of view model there might be a creation of its own repository that is implicitly hidden inside the view model, hereby that repo will probably make
 * real I/O requests for every test. We want our tests to be fast and reliable and not dependent on real third-party APIs.
 *  - Whoever is instantiating the view model doesn't know about viewmodel class's dependencies
 */

class ViewModel() {
    val repository = DependencyContainer.repository
}

class Repository

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * TO alleviate these issues we will refactor view model class to expose its dependencies through its public API to the outside world, the most appropriate way to do that through it public
 * constructor
 */
class ViewModel_ConstrctorInjection(private val repository: Repository){// now the repo dependency is explicit

}
/**
 * When we need to instantiate viewmodel, DependencyContainer will provide it with the necessary dependencies from the outside
 */
fun main(){
    val repo = DependencyContainer.repository
    val viewModel = ViewModel_ConstrctorInjection(repo)
}