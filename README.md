## ももたろうRPG  
こちらからプレイできます。  
[ももたろうRPG (https://momotarorpg.herokuapp.com)](https://momotarorpg.herokuapp.com)

## 職業訓練のグループ課題で制作しました  
グループメンバーの意見を尊重しつつ設計、Model、データベースを一人で担当しました。  
その他のJSP、CSSやサーブレットが行き詰った場合などにサポートを行ったり、改善案のサンプルを作成し提出から実装したりもすることができました。
周回を前提とするようなデザインになっているのですがストーリー性を重視されたメンバーの意見により、  
ステージと敵の生成は固定です。データベースの仕様では敵の生成はランダムにするなどが可能になっております。  
  
## 環境  
グループ課題時の制作環境  
Eclipse IDE  
Apache Tomcat 9  
JavaSE11 jsp+Servlet  
H2 Database Engine  
  
今回GithubにアップロードしてHerokuで動作させるために当たり、  
tomcat→Maven  
H2DB→PostgreSQL  
以上への移行を行いました。  
  
### 移行に苦戦したこと
・Herokuを利用したことがなかった。  
・Mavenについての理解。主にpom.xml(ライブラリの追加等)、web.xmlへの記述次第で動いたり動かないことがあった。  
・移行先のSQLサーバーへのアクセス。SSLの使用が必須だということに気づかず苦戦。  
・SQLのデータの移行。Javaで移行用のアプリケーションを制作し使用。  
[H2DB-to-SQL (https://github.com/kteworks/H2DB-to-SQL)](https://github.com/kteworks/H2DB-to-SQL)
