Satellite Protection System for the China National Space Ad-ministration (CNSA)

JAVA source code Version 1.0  and test report 

-------------------------------------------------------------------------------
Excuting environment: Windows + eclipse

-------------------------------------------------------------------------------
By SPM_Team_3: Li Xingmeng, Zhong Jian, Wang Chenxing, Wang Luyao
3012218070 王晨星 3012218125 王璐瑶 3012218142 李兴猛 3012218162 钟健
Project Manager: Wang Luyao
Tester: Wang Chenxing
Programmers: Li Xingmeng, Zhong Jian

-------------------------------------------------------------------------------
Project Description

Background:
There are approximately 3,000 satellites currently in orbit around the earth. These satellites are in a number of nearly circular orbits ranging in altitude from 100 to 150 nautical miles (low earth orbit), 300 to 600 nautical miles (medium earth orbit) and 23,000 nautical miles (Synchro-nous Equatorial orbit, SyncEq). There are also satellites in highly eccentric orbits whose apogee is as high as 23,000 nautical miles and whose perigee can be as low as a few 100 nautical miles. The orbits range in inclination from 0 to 90 degrees. Along with these Satellites there are approx-imately 19,000 other tracked objects (objects larger than 5cm) orbiting the earth (space junk). This “space junk” is comprised of spent boosters, nuts, bolts from launches and the remnants of satellites that have inadvertently (and in some cases intentionally) run into each other. The pic-ture on the right graphically depicts this space junk. As you can see most is in low earth orbit. The clear ring is the synchronous equatorial orbit.
Regardless of the reason for the existence of space junk, it poses a potential threat to ex-isting and future satellites and CNSA tracks these objects on a continuous basis.


Key Threads(Main Functions)

1. Update satellite data
Allow users to add information into the EXCEL shit autoly. Each satellite has three datas: semiminor, semimajor, true anomaly. 
2. Read the satellite input data
The data is saved in excel and readed by program.
3. Give warning for potential satellite collision
When there would be any collision in five days, the program will give a warning that which satellite would have a collision in five days. It will give the code number of those satellites.


-------------------------------------------------------------------------------
How to use it

1. Update satellite data:
Input: Semiminor, Semimajor, True anomaly and Satellite Name
Then: Click commit to confirm your input data

2. Give warning for potential satellite collision:
The “check” button will check all of the satellites in the shit to find out whether there would be any satellite will have a collision in five days. If there would be none collision in five days, the program will give a output text: everything is ok!

3. Tips:
Please save the data as "test.xls" and put it in WIN(C∶)
The form of data should be:
Name	A	B	C
Sate1	100	130	1.1
Sate2	80	140	1.0

The operation steps are showed in “Project test report.doc”
