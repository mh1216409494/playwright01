package util;

import com.microsoft.playwright.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Logger;

public class TraceUtil {
    private Logger log = Logger.getLogger("TraceUtil.class");
    private Playwright playwright = Playwright.create();
    //    public BrowserContext context = playwright.chromium().launch().newContext();
//    public BrowserContext context = playwright.chromium().launch().newContext(new Browser.NewContextOptions().setViewportSize(1600,900));
    public BrowserContext context = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
    private Page page;

    public TraceUtil() {
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public void setPlaywright(Playwright playwright) {
        this.playwright = playwright;
    }

    public BrowserContext getContext() {
        return context;
    }

    public void setContext(BrowserContext context) {
        this.context = context;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    public Page startTrace(){
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        return context.newPage();
    }

    public void stopTrace(){
        File file = new File("D:"+File.separator+"trace");
        if(!file.exists()){
            file.mkdirs();
        }
        String traceFile = "trace"+File.separator+UUID.randomUUID()+"trace.zip";
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceFile)));
        if((new File(System.getProperty("user.dir")+File.separator+ traceFile)).exists()){
            log.info("日志已存储在"+System.getProperty("user.dir")+traceFile);
        }
    }
}
