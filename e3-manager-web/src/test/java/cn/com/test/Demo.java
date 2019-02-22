package cn.com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.utils.FastDFSClient;

public class Demo {
     
	@Test
	public void test() throws Exception{
		ClientGlobal.init("C:/Users/Administrator/git/e3mall/e3mall/e3-manager-web/src/main/resources/conf/client.conf");
		
		TrackerClient trackerClient = new TrackerClient();
		
		TrackerServer trackerServer = trackerClient.getConnection();
		
		StorageClient storageClient = new StorageClient(trackerServer,null);
		
		String[] fileName = storageClient.upload_file("e:/image/jsy.jpg", "jpg", null);
		
		for(String name:fileName){
			System.out.println(name);
		}
	}
	
	@Test
	public void test2() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("C:/Users/Administrator/git/e3mall/e3mall/e3-manager-web/src/main/resources/conf/client.conf");
		String fileName = fastDFSClient.uploadFile("E:/image/timg.jpg");
		System.out.println(fileName);
	}
}
