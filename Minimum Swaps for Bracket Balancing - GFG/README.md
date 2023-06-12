# Minimum Swaps for Bracket Balancing
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the form S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping <strong>adjacent</strong> characters. <br>Calculate the minimum number of swaps necessary to make a string balanced.<br><br><strong>Note - Strings S1 and S2 can be empty.</strong></span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>  : []][][
<strong>Output</strong> : 2
<strong>Explanation </strong>:
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]</span>

</pre>
<p><strong><span style="font-size: 18px;">Example 2:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input</strong> : [[][]]
<strong>Output</strong> : 0 
<strong>Explanation</strong>:
String is already balanced.</span></pre>
<p>&nbsp;</p>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong></p>
<p><span style="font-size: 18px;">You don't need to read input or print anything. Your task is to complete the function <strong>minimumNumberOfSwaps()</strong> which takes the string S and return minimum number of operations required to balance the bracket sequence.<br><br></span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(N)<br><strong>Expected Auxiliary Space:</strong> O(1)<br><br></span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong></span></p>
<p><span style="font-size: 18px;">1&lt;=|S|&lt;=100000</span></p>
<p>&nbsp;</p></div>