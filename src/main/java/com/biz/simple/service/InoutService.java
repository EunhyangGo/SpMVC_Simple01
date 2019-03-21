package com.biz.simple.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.simple.vo.InoutVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InoutService {
	List<InoutVO> inoutList = new ArrayList<InoutVO>();
	String fileName = "inout.txt";
	
	// inout.txt파일을 src>main>resources에 들어있는데
	// 이때 classpath:이라고 하면 자동으로 읽어지게 된다.
	
	/*
	 * inout.txt파일을 읽어서 
	 * 각 라인을 splite으로 분해한후
	 * 항목별로 vo에 담고,
	 * List<InoutVO>에 추가해서 상품매입매출 List를 생성
	 */
	public List<InoutVO> getInout() {
		
		// src/main/resources 폴더에 있는 fileName 정보를 가져와라
		ClassPathResource rs = new ClassPathResource(fileName);
		
		// fileReader의 새로운 버전이라고 볼 수 있음 = inputStreamReader
		// 1.8(1.7)이상에서 파일이나, 네트워크를 통해서 정보(내용)을 읽을때 사용하는 클래스
		InputStreamReader is;
		BufferedReader buffer;
		
		try {
			is = new InputStreamReader(rs.getInputStream());
			buffer = new BufferedReader(is);
			String reader = "";
			
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				
				String[] inout = reader.split(":");
				InoutVO vo =  new InoutVO();
				
				vo.setIo_date(inout[0]);
				vo.setIo_time(inout[1] +":"+ inout[2] +":"+ inout[3]);
				vo.setIo_cname(inout[4]);
				vo.setIo_check(inout[5]);
				vo.setIo_price(Integer.valueOf(inout[6]));
				vo.setIo_quan(Integer.valueOf(inout[7]));
				
				inoutList.add(vo);
				
			}
			
			return inoutList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/*
	 * 1.8이상에서만 사용 가능 코드
	 */
	/*
	public List<InoutVO> getIolist(){
		
		
		ClassPathResource rs = new ClassPathResource(fileName);
		// Resource 정보에서 인터넷 주소개념의 file정보를 유출
		Path path ;
		

		
		path = Paths.get(rs.getURI());
		List<String> lines = Files.readAllLines(path);
		
		List<InoutVO> iolist = new ArrayList<InoutVO>();
		for(String line : lines) {
			while(true) {
			String[] inout = line.split(":");
			InoutVO vo =  new InoutVO();
			
			vo.setIo_date(inout[0]);
			vo.setIo_time(inout[1] +":"+ inout[2] +":"+ inout[3]);
			vo.setIo_cname(inout[4]);
			vo.setIo_check(inout[5]);
			vo.setIo_price(Integer.valueOf(inout[6]));
			vo.setIo_quan(Integer.valueOf(inout[7]));
			
			inoutList.add(vo);
		}
		
		for(InoutVO vo : iolist) {
			log.debug(vo.toString());
		}
		
		//1.8 버전용 for
		lines.forEach(log::debug);
		for(String line1 : lines) {log.debug(line1); };
		
		return iolist;
		}
		
		
		
		return null;
	}
*/
}