package com.cap.portal.service.impl;

import java.util.List;
import java.util.Map;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.HttpClientUtil;
import com.cap.common.utils.JsonUtils;
import com.cap.pojo.CapItemDesc;
import com.cap.pojo.CapItemParamItem;
import com.cap.portal.pojo.ItemInfo;
import com.cap.portal.service.ItemService;

/**
 * 商品信息管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITME_INFO_URL}")
	private String ITME_INFO_URL;
	@Value("${ITEM_DESC_URL}")
	private String ITEM_DESC_URL;
	@Value("${ITEM_PARAM_URL}")
	private String ITEM_PARAM_URL;
	@Value("${ITEM_RECORD_URL}")
	private String ITEM_RECORD_URL;
	@Value("${ITEM_OVERTIME_URL}")
	private String ITEM_OVERTIME_URL;

	@Override
	public ItemInfo getItemById(Long itemId) {

		try {
			//调用rest的服务查询商品基本信息
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
			if (!StringUtils.isBlank(json)) {
				TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, ItemInfo.class);
				if (taotaoResult.getStatus() == 200) {
					ItemInfo item = (ItemInfo) taotaoResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 	取商品描述
	 * <p>Title: getItemDescById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see com.cap.portal.service.ItemService#getItemDescById(Long)
	 */
	@Override
	public String getItemDescById(Long itemId) {
		try {
			//查询商品描述
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
			//转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapItemDesc.class);
			if (taotaoResult.getStatus() == 200) {
				CapItemDesc itemDesc = (CapItemDesc) taotaoResult.getData();
				//取商品描述信息
				String result = itemDesc.getItemDesc();
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * 取商品竞拍记录
	 */
	@Override
	public CapAuctionRecord getItemRecordById(Long itemId) {
		try {
			//查询商品竞拍记录
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_RECORD_URL + itemId);
			//转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapAuctionRecord.class);
			if (taotaoResult.getStatus() == 200) {
                CapAuctionRecord itemRecord = (CapAuctionRecord) taotaoResult.getData();
				//取商品竞拍记录
				return itemRecord;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public String getItemRecordById(Long itemId) {
//		try {
//			//查询商品描述
//			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_RECORD_URL + itemId);
//			//转换成java对象
//			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapAuctionRecord.class);
//			if (taotaoResult.getStatus() == 200) {
//				CapAuctionRecord itemRecord = (CapAuctionRecord) taotaoResult.getData();
//				//取商品描述信息
//				return itemRecord.toString();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}



	/**
	 * 根据商品id查询规格参数
	 * <p>Title: getItemParam</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see com.cap.portal.service.ItemService#getItemParam(Long)
	 */
	@Override
	public String getItemParam(Long itemId) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
			//把json转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapItemParamItem.class);
			if (taotaoResult.getStatus() == 200) {
				CapItemParamItem itemParamItem = (CapItemParamItem) taotaoResult.getData();
				String paramData = itemParamItem.getParamData();
				//生成html
				// 把规格参数json数据转换成java对象
				List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
				StringBuffer sb = new StringBuffer();
				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
				sb.append("    <tbody>\n");
				for(Map m1:jsonList) {
					sb.append("        <tr>\n");
					sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
					sb.append("        </tr>\n");
					List<Map> list2 = (List<Map>) m1.get("params");
					for(Map m2:list2) {
						sb.append("        <tr>\n");
						sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
						sb.append("            <td>"+m2.get("v")+"</td>\n");
						sb.append("        </tr>\n");
					}
				}
				sb.append("    </tbody>\n");
				sb.append("</table>");
				//返回html片段
				return sb.toString();
			}
				 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	@Override
	public  List<CapItem> getOvertimeItem(){
        try {
            //查询过期商品列表
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_OVERTIME_URL);
            //转换成java对象
            TaotaoResult taotaoResult = TaotaoResult.formatToList(json, CapItem.class);
            if (taotaoResult.getStatus() == 200) {
                List<CapItem> itemList = (List<CapItem>) taotaoResult.getData();
                //取过期商品列表
                return itemList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
