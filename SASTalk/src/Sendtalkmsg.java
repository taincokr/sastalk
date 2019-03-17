/**
 * SAS-JAVA Wrapper Class
 * 2019.3.15
 */

/**
 * @author 
 *
 */

import static skt.tmall.talk.dto.type.AppKdCdType.ELEVENSTAPP;

import java.util.Date;
import java.util.List;

import skt.tmall.talk.dto.PushTalkParameter;
import skt.tmall.talk.dto.type.AppKdCdType;
import skt.tmall.talk.dto.type.Block;
import skt.tmall.talk.dto.type.BlockBoldText;
import skt.tmall.talk.dto.type.BlockBtnView;
import skt.tmall.talk.dto.type.BlockImg500;
import skt.tmall.talk.dto.type.BlockLinkUrl;
import skt.tmall.talk.dto.type.BlockTopCap;
import skt.tmall.talk.service.PushTalkSendService;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;


public class Sendtalkmsg {
 public static void main(String[] arg) throws Exception {
     // ���� ó��
     Aaaaa aaaaa = new Aaaaa();
     int ret = aaaaa.exec();
 }

}

class  Aaaaa {

  //�⺻����
  private Long memNo = 18468196L; //ȸ����ȣ  ����12774111, �迵õ18468196
  private String talkMsgTmpltNo = "002"; //�˸��� ���ø��� ����� �޽��� Ÿ���ڵ�
  private AppKdCdType appKdCd = ELEVENSTAPP; // �߼۴�� ���ڵ�

 public int exec() throws Exception {


     //Ǫ�ø޽���
     JsonObject obj = new JsonObject();
     obj.addProperty("IOS_MSG", "������ �޽���");
     obj.addProperty("AND_MSG", "�ȵ���̵� �޽���");

     //�˸���޽���
     String summary = "�ֹ� �˸����Դϴ�."; //�˸���� ����Ʈ�� ���� �� �޽���
     List<Block> composites = Lists.newArrayList(
             new BlockTopCap(new BlockTopCap.Value("�мǿ�ũ", "����"))
             , new BlockBoldText(new BlockBoldText.Value("�ݰ� Ÿ�ӵ� �Ϸ� 4�� ����", "��ġ��������!"))
             , new BlockImg500(Lists.newArrayList(
                     new BlockImg500.Value("http://img.11st.co.kr/img/sample.jpg")
             ))
             , new BlockBtnView(new BlockBtnView.Value("�󼼺���",
                     new BlockLinkUrl("http://m.11st.co.kr/", "http://11st.co.kr")
             ))
     );

     //�޽��� ����
     PushTalkParameter data = new PushTalkParameter(talkMsgTmpltNo, memNo);
     data.setAppKdCd(appKdCd);
     data.setPushTopMessage(obj.toString());
     data.setPushBottomMessage(obj.toString());
     data.setPushIosMessage(obj.toString());
     data.setTalkSummaryMessage(summary);
     data.setTalkMessage(composites);


//����߼�
     data.setSendAllwBgnDt(new Date()); //����߼۽� ����.  ����߼۽ð��� java.util.Date Ÿ������ �ۼ�.


//SMS ���� http://wiki.11stcorp.com/pages/viewpage.action?pageId=214088691
//     data.setSmsMsg("SMS ���忡 �ش��ϴ� ������ �ۼ�");

//�˸��� ����
     PushTalkSendService.INSTANCE.remoteSyncPush(Lists.newArrayList(data));

     return 0;
 }
}


