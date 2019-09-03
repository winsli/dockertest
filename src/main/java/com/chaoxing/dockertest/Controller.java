package com.chaoxing.dockertest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaoxing.dockertest.utils.Base64Util;

@RestController
public class Controller {

	@GetMapping("/")
	public String index() {
		return "Hello Docker!";
	}

    @GetMapping("/systime")
    public Date getSystime()
    {
        return new Date();
    }

    /**
     * 列出某个目录的详情
     * 
     * @return
     */
    @GetMapping("/listpath")
    public List<String> listPath(String path)
    {
        List<String> out = new ArrayList<>();
        File file = new File(Base64Util.decoder(path));
        if (file.isDirectory())
        {
            for (File one : file.listFiles())
            {
                out.add(one.getName());
            }
        }
        return out;
    }

    /**
     * 创建目录
     * 
     * @return
     */
    @GetMapping("/mkdir")
    public String mkdir()
    {
        Random rand = new Random();
        int num = rand.nextInt(10);
        File file = new File("/opt/".concat(String.valueOf(num)));
        if (file.exists())
        {
            return "directory: " + num + " is exist!!!";
        }
        else
        {
            if (file.mkdirs())
            {
                return "create directory:" + num + " succ.";
            }
            else
            {
                return "create directory:" + num + " fail!!!";
            }
        }
    }

    /**
     * 创建文件
     * 
     * @return
     */
    @GetMapping("/mkfile")
    public String mkfile()
    {
        Random rand = new Random();
        int num = rand.nextInt(10);
        File file = new File("/opt/".concat(String.valueOf(num)).concat(".txt"));
        if (file.exists())
        {
            return "file: " + num + ".txt is exist!!!";
        }
        else
        {
            try
            {
                if (file.createNewFile())
                {
                    return "create file:" + num + ".txt succ.";
                }
                else
                {
                    return "create file:" + num + ".txt fail!!!";
                }
            }
            catch (IOException e)
            {
                return "create file:" + num + ".txt error:" + e.getMessage();
            }
        }
    }
}
