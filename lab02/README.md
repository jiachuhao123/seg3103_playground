# SEG3103

| Outline | Value |
| --- | --- |
| Course | SEG 3103 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | James Url, jamesurl@uottawa.caa |
| Team | Chuhao jia 8794959<br>Keng Li 7847075 |


## Deliverables

* [https://github.com/jiachuhao123/seg3103_playground/tree/main/lab02](https://github.com/jiachuhao123/seg3103_playground/tree/main/lab02)
* Shared repo above with TA and Professors

### System

Windows 10

### Java

I am running Java openjdk 16

```bash
java --version
java 16.0.1 2021-04-20
Java(TM) SE Runtime Environment (build 16.0.1+9-24)
Java HotSpot(TM) 64-Bit Server VM (build 16.0.1+9-24, mixed mode, sharing)
```


### Exercise1

To run the 'user-registration-app-0.1.0.jar' (in `registration`), run the follwing command in regirstration folder
```bash
java -jar  user-registration-app-0.1.0.jar
```
![Running Java in the console](assets/r1.png)

Then copy http://localhost:8080/ to your browser and login it. You should see the page like this:
![Running Java in the console](assets/r2.png)


| Test Case | Expected Results | Actual Results | Verdict(Pass, Fail, inconclusive) |
| --- | --- | --- | --- |
| 1 | registration request  | Err4, Err5 | Fail |
| 2 | registration request  | Err6 | Fail |
| 3 | registration request  | Err4, Err5 | Fail |
| 4 | registration request  | registration request | Pass |
| 5 | Err1 | Err3, Err4, Err5 | Fail |
| 6 | Err3 | Err3, Err6 | Fail |
| 7 | Err3 | Err3, Err4, Err5 | Fail |
| 8 | Err1 | Err1 | Pass |

