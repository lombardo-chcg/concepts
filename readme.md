# CS Concepts
exploring some fundamental concepts

## 01) Linked List
* Contains a node class, list class, and a runner file
* Singly Linked List
* The list object has various methods including a recursive method for reversing the list

## 02) Recursion & Memoization
* showing the benefit of memoization by calculating numbers in the Fibonacci sequence
* performance of straight recursive method vs. recursive method w/ memoization
* example 1: find the 10th Fibonacci number:
```
                         user     system      total        real
straight recursive:  0.000000   0.000000   0.000000 (  0.000233)
with memo:           0.000000   0.000000   0.000000 (  0.000010)

```
* example 2: find the 35th Fibonacci number:
```
                         user     system      total        real
straight recursive:  3.140000   0.000000   3.140000 (  3.143818)
with memo:           0.000000   0.000000   0.000000 (  0.000017)

```
* example 3: find the 40th Fibonacci number:
```
                         user     system      total        real
straight recursive: 35.220000   0.000000  35.220000 ( 35.222465)
with memo:           0.000000   0.000000   0.000000 (  0.000020)
```

## 03) HTTP
* a fun Pi and Twilio application using basic HTTP
* User sends text to a Twilio number.  Twilio dispatches request to 'Middleman Server' (index.js).  Middleman Server sends request to Pi server.  Pi takes still picture using `raspistill` command.  Pi responds to request with id of photo.  Middleman Server sends response back to Twilio which includes URL of photo.  End user recieves photo as MMS.

## 04) Fixed Array
* implement a fixed array data structure without using any build in Ruby data structures
* #get, #set and custom errors included