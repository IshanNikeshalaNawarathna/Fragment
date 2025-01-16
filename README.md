
# Android Fragment Lifecycle

## Overview

This document provides an overview of the Android Fragment Lifecycle and highlights its key lifecycle methods. Fragments are modular components that allow for more flexible UI design within Android apps. Understanding their lifecycle is essential for creating robust and maintainable applications.

## Key Lifecycle Methods

1. **onAttach(Context context)**

   - Called when the fragment is first attached to its host activity.
   - Use this method to initialize resources that the fragment depends on from the activity.

2. **onCreate(Bundle savedInstanceState)**

   - Called to perform the initial setup of the fragment.
   - Use this method to initialize variables, retained data, or configurations.

3. **onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)**

   - Called to create the view hierarchy for the fragment.
   - Inflate the layout XML file and return the root view.

4. **onViewCreated(View view, Bundle savedInstanceState)**

   - Called after the view hierarchy has been created.
   - Use this method to set up UI components (e.g., setting listeners, populating data).

5. **onStart()**

   - Called when the fragment becomes visible to the user.
   - Use this method to start animations, load data, or register listeners.

6. **onResume()**

   - Called when the fragment starts interacting with the user.
   - Use this method to handle UI updates or resume paused processes.

7. **onPause()**

   - Called when the fragment is partially obscured (e.g., the user navigates away but the fragment is still in memory).
   - Use this method to pause animations or release resources that aren’t needed when the fragment is not active.

8. **onStop()**

   - Called when the fragment is no longer visible to the user.
   - Use this method to release resources that are not needed when the fragment is hidden.

9. **onDestroyView()**

   - Called to clean up resources related to the fragment’s view.
   - Use this method to release references to views to avoid memory leaks.

10. **onDestroy()**

    - Called when the fragment is being destroyed.
    - Use this method to clean up remaining resources and state.

11. **onDetach()**

    - Called when the fragment is detached from its host activity.
    - Use this method to release references to the activity or context.

## Lifecycle Diagram

![Android Lifecycle Diagram](https://developer.android.com/static/images/guide/fragments/fragment-view-lifecycle.png)

## Visual Representation of the Lifecycle

1. Fragment is attached to the activity (**onAttach**).
2. Fragment is created (**onCreate**).
3. Fragment’s view is created (**onCreateView**, **onViewCreated**).
4. Fragment becomes visible (**onStart**, **onResume**).
5. Fragment is paused or stopped (**onPause**, **onStop**).
6. Fragment’s view is destroyed (**onDestroyView**).
7. Fragment is destroyed (**onDestroy**).
8. Fragment is detached from the activity (**onDetach**).

## Best Practices

- Use **onAttach** for activity-related initialization.
- Inflate views in **onCreateView** and set up UI in **onViewCreated**.
- Release resources in **onDestroyView** and **onDetach**.
- Avoid performing time-consuming tasks in **onCreateView**; use background threads if needed.

## Example Code

MainActivity code:

```java

        Button activityButtons1 = findViewById(R.id.activebutton);
        activityButtons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView activityText = findViewById(R.id.activitytextView);
                activityText.setText("Activity button 1 Hello");
            }
        });

        Button activityButtons2 = findViewById(R.id.addFragmentbutton);
        activityButtons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, TestFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        Button activityButtons3 = findViewById(R.id.updateFragmentTextViewButton);
        activityButtons3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView activityText = findViewById(R.id.fragmentTextView);
                activityText.setText(" Activity button 3 Hello");
            }
        });

```
![image1](https://github.com/user-attachments/assets/c924055d-16ce-4847-aaf6-52c78530507f)

FragmentActivity code:

```java

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button updateFragmentViewText = getView().findViewById(R.id.updateFragmentViewText);
        updateFragmentViewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getView().findViewById(R.id.fragmentTextView);
                textView.setText("Fragment button 1 Hello");
            }
        });

        Button updateActivityTextView = getView().findViewById(R.id.updateActivityTextView);
        updateActivityTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getActivity().findViewById(R.id.activitytextView);
                textView.setText("Fragment button 2 Hello");
            }
        });
    }

```
![image](https://github.com/user-attachments/assets/9fbe175e-347b-4c4d-947e-381904076109)

## Conclusion

Understanding the fragment lifecycle is essential for efficient memory management, avoiding memory leaks, and creating a seamless user experience. Use this guide to implement and manage fragments effectively in your Android applications.

 ---
Happy coding! 🎉
