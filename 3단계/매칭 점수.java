import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    final String startHead = "<head>";
    final String endHead = "</head>";
    final String startMeta = "<meta";
    final String finishSign1 = ">";
    final String finishSign2 = "\"";
    final String https = "https";
    final String href = "<a href=";
    Map<String, PageInfo> urlOfPageInfo = new HashMap<String, PageInfo>();
    
    public int solution(String word, String[] pages) {
        int answer = 0;
        int length = pages.length;
        word = word.toLowerCase();
        int wordLength = word.length();
        
        PageInfo[] arr = new PageInfo[length];
        
        for(int i=0; i<length; i++) {
            arr[i] = pageScan1("/"+pages[i]+"/", word, wordLength);
        }
        
        for(int i=0; i<length; i++) {
            pageScan2(urlOfPageInfo.get(arr[i].url), pages[i], arr);
        }
        
        double max = -1;
        
        for(int i=0; i<length; i++) {
            double result = 0;
            PageInfo pageInfo = arr[i];
            List<PageInfo> externalLink = pageInfo.externalLink;
            int linkLength = externalLink.size();
            
            result += pageInfo.baseScore;
            for(int j=0; j<linkLength; j++) {
                result += externalLink.get(j).linkScore;
            }
            
            if(result > max) {
                max = result;
                answer = i;
            } 
        }
        
        
        return answer;
    }
    public void pageScan2(PageInfo myPageInfo, String page, PageInfo[] arr) {
        
        int startHref = 0;
        double linkedURLCount =0;
        
        //연결된 링크 갯수 구하기
        while(true) {
            startHref = page.indexOf(href, startHref);
            if(startHref == -1) {
                break;
            }
            
            int startLinkedURL = page.indexOf(https, startHref);
            int endLinkedURL = page.indexOf(finishSign2, startLinkedURL);
            String linkedURL = page.substring(startLinkedURL, endLinkedURL);
            
            if(urlOfPageInfo.containsKey(linkedURL) == true) {
                PageInfo linkedPageInfo = urlOfPageInfo.get(linkedURL);
                linkedPageInfo.externalLink.add(myPageInfo);
            }
            linkedURLCount++;
            startHref = endLinkedURL;
        }
        myPageInfo.linkScore = myPageInfo.baseScore / linkedURLCount;
    }
    
    public PageInfo pageScan1(String page, String word, int wordLength) {
        
        page = page.toLowerCase();
        int pageLength = page.length();
        PageInfo pageInfo = new PageInfo();
        
        // baseScore 구하기
        int charIndex = 0;
        int wordCount = 0;
        while(true) {
            charIndex = page.indexOf(word, charIndex);
            if(charIndex == -1) {
                break;
            }
            
            char c1 = page.charAt(charIndex+wordLength);
            char c2 = page.charAt(charIndex-1);
            if( !(c1 >= 'a' && c1<= 'z') && !(c2 >= 'a' && c2<= 'z')) {
                wordCount++;
            }
            charIndex++;
        }
        
        pageInfo.baseScore = wordCount;
        
        //URL 구하기
        String url = "";
        String head = page.substring(page.indexOf(startHead), page.indexOf(endHead));
        
        int startMetaIndex =0;
        int endMetaIndex = 0;
        while(true) {
            
            startMetaIndex = head.indexOf(startMeta, startMetaIndex);
            endMetaIndex = head.indexOf(finishSign1, startMetaIndex);
            String meta = head.substring(startMetaIndex, endMetaIndex);
            
            int startURLIndex = meta.indexOf(https);
            
            if(startURLIndex != -1) {
                int endURLIndex = meta.indexOf(finishSign2, startURLIndex);
                url = meta.substring(startURLIndex,endURLIndex);
                break;
            }
            startMetaIndex++;
        }
        pageInfo.url = url;
        urlOfPageInfo.put(url, pageInfo);
        
        return pageInfo;
    }
}

class PageInfo {
    String url;
    int baseScore;
    List<PageInfo> externalLink;
    double linkScore;
    
    public PageInfo() {
        externalLink = new ArrayList<PageInfo>();
        linkScore = -1;
    }
}