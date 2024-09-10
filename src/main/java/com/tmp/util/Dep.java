package com.df.bac.dep;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class Dep {

    /**
     * 执行指定的Shell脚本
     *
     * @return 脚本执行的结果
     */
    @GetMapping("/restart")
    public String restart() {
        StringBuilder result = new StringBuilder();
        try {
            // 指定你要执行的.sh脚本路径
            String scriptPath = "/data/web/sj/restart.sh";
            
            // 执行脚本
            ProcessBuilder processBuilder = new ProcessBuilder(scriptPath);
            Process process = processBuilder.start();
            
            // 获取脚本执行的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            
            // 等待脚本执行结束
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                result.append("脚本执行成功！");
            } else {
                result.append("脚本执行失败，退出代码：").append(exitCode);
            }
            
        } catch (Exception e) {
            result.append("脚本执行过程中发生错误：").append(e.getMessage());
        }
        
        return result.toString();
    }
}
