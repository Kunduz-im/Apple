package demoQA.alertFrameWindows;

import demoQA.BaseDemoQATest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class IFrameTest extends BaseDemoQATest {


    @Test
    void iFrameTest(){
        driver.get("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame1"); //если не было переключение между фраймами
        //то наш тест искал бы этот вебэлемент у родителя , из+-за этого нужно переключаться между фраймами
        //Id фраймов не должно дублироваться, если дублируется то это ошибка
        String txt = iFramePage.getSampleHeading();
        System.out.println(txt);
    }


    @Test
    void iFrameTest2(){
        driver.get("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame2");
        String txt = iFramePage.getSampleHeading();
        System.out.println(txt);
    }

    @Test
    void iFrameTest3(){
        driver.get("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame1");
        String txt = iFramePage.getSampleHeading();
        System.out.println(txt);

        iframeHelper.switchToParentFrame();
        //когда говорим после фрайма switch на другой фрайм, то он ищет внутри себя,
        // а switchToParentFrame ищет фрайм внутри родителя

        iframeHelper.switchToFrame("frame2");
        String txt2 = iFramePage.getSampleHeading();
        System.out.println(txt2);
    }


}
