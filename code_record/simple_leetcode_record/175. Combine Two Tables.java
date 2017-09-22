/*Created by ${USER} on ${DATE}.
 *题意：一个sql  不用管 右边的地址有没有 用left join
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;
