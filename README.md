# Septech_StudyAutomation
================== Bài tập cho Locator ==================
Link: http://live.guru99.com/index.php/mobile.html
1.Vào link live.guru99.com
2.Chọn tab “Mobile” -> Chọn một sản phẩm để “Add to cart”
3.Click “Continue shopping” -> Chọn một sản phẩm khác để add to cart
4.Tìm locator của các element trên trang:
* Giá trị price của một sản phẩm bất kỳ
* Textbox “qty” của một sản phẩm bất kỳ
* Button “delete” một sản phẩm bất kỳ
* Một option “country” từ combo box

===================== Đáp án cho bài tập trên ===============================
 
* Giá trị price của 1 sản phẩm bất kì(chon sản phẩm là SamSungGalaxy)::
   Price_SamSungGalaxy = xpath = //span[@class='price' and text()='$130.00']
   
* Textbox “qty” của một sản phẩm bất kỳ(chon sản phẩm là SamSungGalaxy):
   Qty_SamSungGalaxy = xpath = //input[@name='cart[18441][qty]']
or Qty_SamSungGalaxy = xpath = //input[contains(@name,'cart[18441][qty]']
 
* Button “delete” một sản phẩm bất kỳ(chon sản phẩm là SamSungGalaxy)::
   Delete_name = By.className('btn-remove btn-remove2')
or Delete_linktext = By.linkText('http://live.guru99.com/index.php/checkout/cart/delete/id/18328/uenc/aHR0cDovL2xpdmUuZ3VydTk5LmNvbS9pbmRleC5waHAvY2hlY2tvdXQvY2FydC8,/')
or Delete_xpath1= xpath= //a[@class='btn-remove btn-remove2']
or Delete_xpath2 = xpath = //a[@href='http://live.guru99.com/index.php/checkout/cart/delete/id/18328/uenc/aHR0cDovL2xpdmUuZ3VydTk5LmNvbS9pbmRleC5waHAvY2hlY2tvdXQvY2FydC8,/']
or Delete_xpath3= xpath = //a[@title='Remove Item']
or Delete_xpath4= xpath = //a[contains(@title,'Remove Item')]
or Delete_xpath5 = xpath = //a[@class='btn-remove btn-remove2' and @href='http://live.guru99.com/index.php/checkout/cart/delete/id/18328/uenc/aHR0cDovL2xpdmUuZ3VydTk5LmNvbS9pbmRleC5waHAvY2hlY2tvdXQvY2FydC8,/']

* Một option “country” từ combo box( tôi chọn Angola):
   Country_xpath1 = xpath = //select[@id='country']//option[7]
or Country_xpath2 = xpath = //select[@id='country']//option[@value='AO']
or Country_xpath3 = xpath = //select[@name='country_id']//option[7]
or Country_xpath4 = xpath = //select[@name='country_id']//option[@value='AO']
or Country_id = By.id('country')
or Country_name = By.name('country_id')
   
   
