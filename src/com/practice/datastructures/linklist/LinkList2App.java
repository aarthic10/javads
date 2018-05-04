package com.practice.datastructures.linklist;
class LinkList2App
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make list

      theList.insertFirst(22, 2.99);      // insert 4 items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      theList.displayLinkList();

      Link f = theList.find(44);          // find item
      if( f != null)
         System.out.println("Found link with key " + f.getiData());
      else
         System.out.println("Can't find link");

      Link d = theList.delete(77);
      if( d != null )
         System.out.println("Deleted link with key " + d.getiData());
      else
         System.out.println("Can't delete link");

      theList.displayLinkList();
      }
   }
