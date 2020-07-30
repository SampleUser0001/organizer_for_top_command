# Topコマンドの出力結果を整理する

## TempMain
動作確認用。  
引数で指定したパス配下のファイルを読み込んで、そのままtoStringで標準出力する。

```
mvn exec:java -Dexec.mainClass="jp.tool.linux.organizer.top.TempMain" -Dexec.args="top_logs/20200709"
```

## TempPrintFreeMem
動作確認用。  
引数で指定したパス配下のファイルを読み込んで、メモリの空き(Free)を、output/free-mem.csvに書き込む。  
```
mkdir output
touch output/free-mem.csv
mvn exec:java -Dexec.mainClass="jp.tool.linux.organizer.top.TempPrintFreeMem" -Dexec.args="top_logs/20200709"
```

