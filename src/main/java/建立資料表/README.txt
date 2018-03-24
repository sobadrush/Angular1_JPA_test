$ git tag -n (-n : show tag message) 
MileStone01  ---   完成關聯使用Integer版本的本


【上傳標籤到遠端】
@@ git push 並不會把標籤上傳到遠端，所以必須透過底下才行
https://blog.wu-boy.com/2010/11/git-%E7%89%88%E6%9C%AC%E6%8E%A7%E5%88%B6-%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8%E6%A8%99%E7%B1%A4tag/

【冷知識】斷頭（detached HEAD）是怎麼一回事？ >>> https://gitbook.tw/chapters/faq/detached-head.html
1.在這個狀態可以做什麼？
其實這個狀態沒什麼特別的，就只是 HEAD 剛好指向某個沒有分支指著的 Commit 罷了，所以一樣可以跟平常一樣的操作 Git，一樣可以進行 Commit。

2.怎麼離開 detached HEAD 狀態？
既然已經知道所謂的 detached HEAD 狀態只是 HEAD 沒有指向任何分支造成的，要脫離這個狀態，只要讓 HEAD 有任何分支可以指就行了，例如讓它回到 master 分支：