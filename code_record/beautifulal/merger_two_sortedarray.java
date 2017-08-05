class ArraySort
  {
      //������������ĺϲ�����
      public static int[] MergeList(int a[],int b[])
      {
          int result[];
          if(checkSort(a) && checkSort(b))  //��鴫��������Ƿ��������
          {
              result = new int[a.length+b.length];

             int i=0,j=0,k=0;   //i:���ڱ�ʾa����    j��������ʾb����  k��������ʾ���������

             while(i<a.length && j<b.length)
                 if(a[i] <= b[j]) {
                     result[k++] = a[i++];
                 }else{
                     result[k++] = b[j++];
                 }

             /* ��������whileѭ����������֤��������Ƚ���֮��ʣ�µ�һ���������Ԫ����˳������ */
             while(i < a.length)
                 result[k++] = a[i++];
             while(j < b.length)
                 result[k++] = b[j++];

             return result;
         }
         else
         {
             System.out.print("���������飬��������");
             return null;
         }
     }

     //��������Ƿ���˳��洢��
     public static boolean checkSort(int a[])
     {
         boolean change = true;  //�����־λ��һ���Ż�����ķ��������Կ�����д��ð�������Ż��ͻ�������
         for(int i=0; i<a.length-1 && change; i++)
         {
             for(int j=i+1; j<a.length; j++)
                 if(a[j-1] > a[j])
                     return false;
                 else change = false;
         }
         return true;
     }

     // ��ӡ����
     public static void print(int b[])
     {
          for(int i=0; i<b.length ; i++)
          {
              System.out.print(b[i] + (i%10 ==9 ? "\n":"\t"));
          }
     }

     public static void main(String args[])
     {
         int a[]={1,2,2,3,5,6,7,7};
         int b[]={1,2,4,5,8,8,9,10,11,12,12,13,14};
         int c[]= MergeList(a,b);
         if(c!=null)
         print(c);
         else
             System.out.println("");
     }
 }