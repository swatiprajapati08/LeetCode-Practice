<h2>N meetings in one room </h2><h3>Easy</h3><hr><div><p>There is one meeting room in a firm. There are <strong>N</strong> meetings in the form of <code>(start[i], end[i])</code> where <strong>start[i]</strong> is start time of meeting i and <strong>end[i]</strong> is finish time of meeting i.
What is the <strong>maximum</strong> number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time.</p>

<p><strong>Note:</strong> Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.</p>


<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong>  N = 6
<strong>start[]</strong>= {1,3,0,5,8,5}
<strong>end[]</strong> =  {2,4,6,7,9,9}
<strong>Output:</strong>  4
<strong>Explanation: </strong>Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> N = 3
<strong>start[]</strong> = {10, 12, 20}
<strong>end[]</strong> = {20, 25, 30}
<strong>Output:</strong> 1
<strong>Explanation: </strong>Only one meetings can be held
with given start and end timings. 
</pre>


<strong>Expected Time Complexity:</strong> O(N*LogN)<br>
<strong>Expected Auxilliary Space :</strong> O(N)        


<p><strong>Constraints:</strong></p>

<ul>
	<li><code> 1 &lt;= N &lt;= 10<sup>5</sup></code></li>
  <li><code> 0 &lt;= <strong> start[i] &lt; end[i] </strong>  &lt;= 10<sup>5</sup></code></li>
</ul>
