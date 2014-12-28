MaterialRangeBar
=======
MaterialRangeBar is a fork of https://github.com/edmodo/range-bar that adds some basic material styling, as well as start and end values, values as floats and some other things. It is aiming to mimic this:

http://www.google.com/design/spec/components/sliders.html

It is similar to an enhanced SeekBar widget, though it doesn't make use of the SeekBar. It provides for the selection of a range of values as well as for a single value. The selectable range values are discrete values designated by tick marks; the pin (handle) will snap to the nearest tick mark. This is my first library project, apologies for poor coding, etc etc.

Developers can customize the following attributes (both via XML and programmatically):

- bar color
- bar thickness
- tick size
- tick color
- tick start value
- tick end value
- tick interval
- connecting line thickness
- connecting line color
- pin size
- pin color
- Bar type (Range or seek)

Finally, the following property can be set programmatically, but not via XML:
- pin indices (the location of the thumbs on the RangeBar)

Supported on API Level 12 and above for animations.
https://github.com/oli107/material-range-bar/blob/master/Screenshots/screenshot%20pin%20active.png
![ScreenShot](https://github.com/oli107/material-range-bar/blob/master/Screenshots/screenshot%20pin%20active.png)
![ScreenShot](https://github.com/oli107/material-range-bar/blob/master/Screenshots/screenshot.png)

Instructions
=======
- Add the widget to your view.
- Either in xml (rangeBar="true") or programatically (rangeBar.setRangeBarEnabled(true)). If true will create two "pins" for a range bar, if false, will act as a single seek bar.
- Set start and end values, as well as interval. These are float values, the view will autoatically calculate the correct indices/tick count.
- Add a listener - rangeBar.setOnRangeBarChangeListener which returns left and right index as well as value.
- Style the view as you want.
- That's it!


TODO
=======
- Better instructions.
- Properly implement Map of strings to each value
- Generally make it a better project!

Demo
=======
[Get it from the Google Play Store](https://play.google.com/store/apps/details?id=com.appyvet.rangebarsample)


Installation
=======

**build.gradle**

	 maven {
        url 'http://dl.bintray.com/oli107/maven'
    }

	dependencies {
    compile 'com.appyvet:rangebar:0.0.7'
	}

License
=======
Copyright 2014, AppyVet, Inc. 

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

