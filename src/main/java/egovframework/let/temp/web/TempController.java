package egovframework.let.temp.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class TempController {
	
	@Resource(name="tempService")
	private TempService tempService;
	
	//임시데이터 가져오기
	@RequestMapping(value="/temp/select.do")
	public String select(TempVO tempVO, HttpServletRequest request,ModelMap model) throws Exception{
		TempVO result = tempService.selectTemp(tempVO);
		model.addAttribute("result",result);
		return "temp/TempSelect";
	}

	//임시데이터 목록 가져오기
		@RequestMapping(value="/temp/selectList.do")
		public String selectList(TempVO tempVO, HttpServletRequest request,ModelMap model )throws Exception{
			// list : java. util.list
			List<EgovMap> resultList = tempService.selectTempList(tempVO);
			model.addAttribute("resultList", resultList);
			
			return "temp/TempSelectList";
	}
		
	// 임시데이터 등록/수정
		@RequestMapping(name="/temp/tempRegist.do")
		public String tempRegist(TempVO tempVO, HttpServletRequest request,ModelMap model )throws Exception{
		
//		// ==2차 코딩내용 (수정 추가하기 )========//
			TempVO result = new TempVO();
			
			if(!EgovStringUtil.isEmpty(tempVO.getTempId())) {
				result=tempService.selectTemp(tempVO);
			}
			model.addAttribute("result",result);
			// result 객체를 만들고 result는 기본적으로 null 값이다
			// 현재 EgovStringUtil.isEmpty를 조회해보고, getTempId값이 empty가 아니라면 
			// 그 밑의 result값을 보내준다.그런후 model에 저장해서 regist페이지에 출력
			
			// ==================================//
			
			return "temp/TempRegist";
			
			
	}
	
	// 임시데이터 등록하기 (진짜 데이터 등록이 됨)
		
		@RequestMapping(value="/temp/insert.do")
		//이것은 "@RequestMapping(value="/temp/insert.do")" 주석이 있는 Java 메서드로, 
		//클라이언트가 요청할 때 특정 URL 경로 "/temp/insert.do"에 매핑됨을 나타냅니다.
		public String insert(TempVO tempVO, HttpServletRequest request,ModelMap model )throws Exception{
			tempService.insertTemp(tempVO);
			return "forward:/temp/selectList.do";
		}
		
	//임시데이터 수정하기
		@RequestMapping(value = "/temp/update.do")
		public String update(TempVO tempVO,HttpServletRequest request) throws Exception{
			tempService.updateTemp(tempVO);
			return "forward:/temp/selectList.do";
		}
	//임시데이터 삭제하기
		@RequestMapping(value="/temp/delete.do")
		public String delete(TempVO tempVO,HttpServletRequest request) throws Exception{
			tempService.deleteTemp(tempVO);
			return "forward:/temp/selectList.do";
		}
	//JSTL
		@RequestMapping(value="/temp/jstl.do")
		public String jstl(TempVO searchVO,HttpServletRequest request,ModelMap model) throws Exception{
			
			return"/temp/jstl";
		}
	//JSTL c:import용
		@RequestMapping(value="/temp/jstlImport.do")
		public String jstlImport(TempVO searchVO,HttpServletRequest request,ModelMap model) throws Exception{
			return "/temp/jstlImport";
		}
		
}
