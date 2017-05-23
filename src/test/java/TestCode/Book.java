/**
 
* Copyright (c) 2014 Baozun All Rights Reserved.
 
*
 
* This software is the confidential and proprietary information of Baozun.
 
* You shall not disclose such Confidential Information and shall use it only in
 
* accordance with the terms of the license agreement you entered into
 
* with Baozun.
 
*
 
* BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 
* PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 
* THIS SOFTWARE OR ITS DERIVATIVES.
 
*
 
*/
package TestCode;

/**
 * @author liuwen
 * @version 1.0
 * @date 2017年5月23日
 * funcation : 
 */
public class Book{
    private String c_id;
    private String name;
    private String isbn;
    private String price;
    
    public String getId(){
        return c_id;
    }
    
    public void setId(String id){
        this.c_id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Book [id=" + c_id + ", name=" + name + ", isbn=" + isbn + ", price=" + price + "]";
    }
    
}
