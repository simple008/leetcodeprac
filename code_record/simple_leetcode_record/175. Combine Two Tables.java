/*Created by ${USER} on ${DATE}.
 *���⣺һ��sql  ���ù� �ұߵĵ�ַ��û�� ��left join
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;
