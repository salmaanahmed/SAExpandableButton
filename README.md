# SAExpandableButton

# Description
Expandable button is lightweight custom button which hides and shows child views on click automatically.
It is customizeable, you can change text, icon and color both programatically and in XML.
It also have callback listeners which enables it to be used in various enviornments.
<br>
<img height="400" src="https://github.com/salmaanahmed/SAExpandableButton/blob/master/screenshots/Screenshot_ExpandableButton.png?raw=true" />
<br>
# Demonstration
You can use any view as a child view for it.
<br>
<img height="400" src="https://github.com/salmaanahmed/SAExpandableButton/blob/master/screenshots/ExpandableButtonGif.gif?raw=true" />
<br>

# Installation
```SAExpandableButton``` can be installed using Maven, Gradle, or manually.

# Maven
**Step 1.** Add the JitPack repository to your build file
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
**Step 2.** Add the dependency
```
<dependency>
    <groupId>com.github.salmaanahmed</groupId>
    <artifactId>SAExpandableButton</artifactId>
    <version>1.0.0</version>
</dependency>
```

# Gradle
**Step 1.** Add the JitPack repository to your build file
```
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Add the dependency
```
dependencies {
  compile 'com.github.salmaanahmedz:SAExpandableButton:1.0.0'
}
```
# Manual Installation
If you prefer not to use either of the above mentioned dependency managers, you can integrate AACustomFont into your project manually by adding the files contained in the java folder to your project.

# Getting Started
# Using XML
You can use expandable button in XML as following
```
<com.interconn.salmaanahmed.saexpandablebutton.ExpandableButton
    android:layout_width="match_parent"
    android:layout_height="50dp"
    app:text="Expandable Button Two"
    app:color="#297e55"
    app:icon="@drawable/ic_arrow_drop_down_black_24dp"
    app:childView="@+id/childView2" />

<TextView
    android:id="@+id/childView2"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:gravity="center"
    android:text="Expandable Button Child Two"
    android:textColor="#fff"
    android:background="@color/colorAccent"/>
```
You can have custom color, arrow icon and text.
All you have to do is set ChildView and it will hide and show automatically on click of the button.
If you want to animate you should use ```android:animateLayoutChanges="true"``` in your root view.

# Using Java
# Referencing View
You can reference the expandable button in java to perform muliple operations
```
expandableButton = findViewById(R.id.expandableButton);
```
# Create expandable button programmatically
You can also create expandable button programatically in java using the following code
```
expandableButton = new ExpandableButton(MainActivity.this);
expandableButton.setChildView(childView);
expandableButton.setBarColor(Color.BLUE);
expandableButton.setIcon(R.drawable.ic_arrow);
```
# Set callback listeners
```
expandableButton.setCallbackListener(new ExpandableButton.ExpandableButtonListener() {
    @Override
    public void onViewExpanded() {
        Toast.makeText(MainActivity.this, "Button Expanded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCollapsed() {
        Toast.makeText(MainActivity.this, "Button Collapsed", Toast.LENGTH_SHORT).show();
    }
});
```

# Contributions and Licence
```SAExpandableButton``` is available under the MIT license. See the [LICENSE](https://github.com/EngrAhsanAli/AACustomFont/blob/master/LICENSE) file for more info.

Pull requests are welcome! The best contributions will consist of substitutions or configurations for classes/methods known to block the main thread during a typical app lifecycle.

I would love to know if you are using AACustomFont in your app, send an email to [Salmaan Ahmed](mailto:salmaan.ahmed@hotmail.com)
