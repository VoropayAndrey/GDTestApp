# Test task:
Please create structural and architectural plan of application with following requirements:
1. App contains NavigationView with several fragments. Some of the fragments should contain nested fragments in FragmentPager.
2. All fragments should communicate with each other on certain event (for ex. Login status change)
3. App should contain separate activity working with some data entity (let’s call it ComplicatedObject) with complicated logic, which contains lots of parts. Parts can be set on and off by different conditions based on data in corresponding ComplicatedObject. Also each part has it’s own logic branching based on ComplicatedObject. Please provide a structure to keep this activity clean, understandable and functional.
4. App style should be easy customizable by flavoring.
5. App logic could alter based on flavor.
6. App should be based on MVVM architecture
7. Please describe possible bottle-necks and problematic places which can occur while implementing this logic and provide code snipets of handling this issues. Feel free to provide code examples of other parts of your solution, that would be a plus.
8. Please also provide some of the classes you’ve developed earlier to check your general codestyle.
9. Please solve one or both of given challenges, and send us your solution:<br/>
https://www.hackerrank.com/challenges/prime-checker/problem<br/>
https://www.hackerrank.com/challenges/java-dequeue/problem<br/>

# Solutions

1. [BaseActivity.kt](app/src/main/java/com/hardway/gdtest/ui/activities/BaseActivity.kt) contains [initToolbar()](https://github.com/VoropayAndrey/GDTestApp/blob/1c5eb796ebac1061635b12d69a38425a00a4c7cd/app/src/main/java/com/hardway/gdtest/ui/activities/BaseActivity.kt#L31) method to setup application Toolbar and NavigationView.
[SlashBaseFragment.kt](https://github.com/VoropayAndrey/GDTestApp/blob/1c5eb796ebac1061635b12d69a38425a00a4c7cd/app/src/main/java/com/hardway/gdtest/ui/fragments/SlashBaseFragment.kt#L30) contains two nested fragments.

2. To be able to communicate with fragments an [event bus](app/src/main/java/com/hardway/gdtest/domain/LoginEventBus.kt) was introduced in the application.
The event bus is based on MutableSharedFlow which act as BehaviorSubject from RxJava.
Any number of fragments or any other object can start to listen of events, for example:
```kotlin
getSharedViewMode().contactsLiveData.observe(viewLifecycleOwner, Observer {
    Log.d(Constants.TAG, "ContactsFragment, login state change, isLoggedIn: ${it.isLoggedIn}")
})
```
Given ViewModel is shared between all fragments.


3. Because the ComplicatedObject has a lot of smaller pieces it would be nice to create a factory for ComplicatedObjects.
In this case Factory Method design pattern is suited well.
![Abstract Method Pattern](images/ComplicatedEntity_AbstractMethod.png)
We will need to change only one class to add new implemntation of ComplicatedEntityInterface.

For the smaller parts some kind of strategy pattern is proposed.
Each of the parts has it own interface and a set of implementation that can be changed based on the processed data.
![Strategy Pattern](images/PartsStructure_Strategy.png)

4. Flavorign is added to the application level gradle file:
[Here](https://github.com/VoropayAndrey/GDTestApp/blob/1c5eb796ebac1061635b12d69a38425a00a4c7cd/app/build.gradle#L42)
This flavoring will change the colors of the app based on the app structure:
![App structure](images/app_structure.png)

5. Different project flavor has it own implmenetation of ComplicatedEntityInterface [ComplicatedEntityImplementation1](app/src/dark/java/com/hardway/gdtest/domain/entities/ComplicatedEntityImplementation1.kt) and [ComplicatedEntityImplementation2](app/src/dark/java/com/hardway/gdtest/domain/entities/ComplicatedEntityImplementation2.kt).

6. Currently the app has 4 different ViewModel.
Each view model is instantiated by viewModels() using Dagger2/Hilt to inject dependencies to the ViewModels.

7. Bottle necks

8. Classes.

9. Challenges:

9.1. Prime problem:
Description:
https://www.hackerrank.com/challenges/prime-checker/problem

Solution:
[PrimeChecker.java](app/src/test/java/com/hardway/gdtest/PrimeChecker.java)

9.2. Dequeue problem:
Description:
https://www.hackerrank.com/challenges/prime-checker/problem

Solution:
[JavaDequeue.java](app/src/test/java/com/hardway/gdtest/JavaDequeue.java)
