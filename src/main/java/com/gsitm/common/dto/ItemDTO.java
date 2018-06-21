package com.gsitm.common.dto;

import java.util.Arrays;

/**
 * @programName : ItemDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class ItemDTO {
	private String itemSeq;
	private String itemCode;
	private String itemType;
	private String itemName;
	private String itemPrice;
	private String itemUnit;
	private String itemDescription;
	
	private byte[] itemImg;
	private byte[] itemImg2;
	private byte[] itemImg3;
	
	public String getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public byte[] getItemImg() {
		return itemImg;
	}
	public void setItemImg(byte[] itemImg) {
		this.itemImg = itemImg;
	}
	public byte[] getItemImg2() {
		return itemImg2;
	}
	public void setItemImg2(byte[] itemImg2) {
		this.itemImg2 = itemImg2;
	}
	public byte[] getItemImg3() {
		return itemImg3;
	}
	public void setItemImg3(byte[] itemImg3) {
		this.itemImg3 = itemImg3;
	}
	@Override
	public String toString() {
		return "ItemDTO [itemSeq=" + itemSeq + ", itemCode=" + itemCode + ", itemType=" + itemType + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", itemUnit=" + itemUnit + ", itemDescription="
				+ itemDescription + ", itemImg=" + Arrays.toString(itemImg) + ", itemImg2=" + Arrays.toString(itemImg2)
				+ ", itemImg3=" + Arrays.toString(itemImg3) + "]";
	}
	
}
