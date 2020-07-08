package jp.tool.linux.organizer.top;

/**
 * topコマンドの結果を整理する。
 */

// Mem:   1009148k total,   809316k used,   199832k free,   245708k buffers
// Swap:   499996k total,        0k used,   499996k free,   323828k cached

//   PID USER      PR  NI  VIRT  RES  SHR S %CPU %MEM    TIME+  COMMAND                                                                                           
//     1 root      20   0 19696 2608 2284 S  0.0  0.3   0:01.07 init                                                                                              

public class TopOrganizer {
    public static void main( String[] args ) {
        // 4行目 : Mem:
        // 5行目 : Swap:
        // 6行目 : 空行
        // 7行目 : ヘッダ
        
        System.out.println( "Hello World!" );
    }
}
