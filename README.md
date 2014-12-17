MaterialRangeBar
=======
MaterialRangeBar is a fork of https://github.com/edmodo/range-bar that adds some basic material styling, as well as start and end values, values as floats and some other things. It is similar to an enhanced SeekBar widget, though it doesn't make use of the SeekBar. It provides for the selection of a range of values rather than a single value. The selectable range values are discrete values designated by tick marks; the pin (handle) will snap to the nearest tick mark. There is also a version just as a seek bar, with a single pin.

Developers can customize the following attributes (both via XML and programmatically):

- bar color
- bar thickness
- tick height
- tick color
- tick start value
- tick end value
- number of ticks
- connecting line thickness
- connecting line color
- pin size
- pin color

Finally, the following property can be set programmatically, but not via XML:
- pin indices (the location of the thumbs on the RangeBar)
- Map of strings to each value

Supported on API Level 7 and above.

![ScreenShot](http://i.imgur.com/q85GhRjl.png)

Installation
=======

**build.gradle**

	 maven {
        url 'http://dl.bintray.com/oli107/maven'
    }

	dependencies {
    compile 'com.appyvet:rangebar:1.0.0'
	}

License
=======
Copyright 2014, AppyVet, Inc. 

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

