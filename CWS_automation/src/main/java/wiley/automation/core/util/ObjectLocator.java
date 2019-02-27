package wiley.automation.core.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ObjectLocator extends ObjectRepository {
	
	//---------------------------------Start of BPA Section----------------------------------------------------------------------

	// BPA Login Page
	/*public static By BPA_Login_username = By.id(ALMuserid);
    public static By BPA_Login_password = By.id(ALMPasswordid);
    public static By BPA_Login_submit = By.id(submitALM_loginid);*/
	
	// BPA Home Page
	
	public static By wipPlusMenu=By.xpath(wipPlusMenuXpath);
	public static By createWIPrecord=By.id(createWIPrecordXpath);
	public static By createNewTitleRecord_EnterISBN=By.id(createNewTitleRecord_EnterISBNXpath);
	public static By createNewTitleRecord_CreateButton=By.xpath(createNewTitleRecord_CreateButtonXpath);
	public By createNewTitleRecord_PubExistPopUp=By.id(createNewTitleRecord_PubExistPopUpXpath);
	public static By createNewTitleRecord_PubExistPopUp_Cancel=By.linkText(createNewTitleRecord_PubExistPopUp_CancelXpath);
	public static By createNewTitleRecord_RelatedISBNPopUp_Continue=By.xpath(createNewTitleRecord_RelatedISBNPopUp_ContinueXpath);
	public static By createNewTitleRecord_ColtraneMDPopUp_Create=By.xpath(createNewTitleRecord_ColtraneMDPopUp_CreateXpath);
	public static By titleMsg=By.id(titleMsgXpath);
	public static By homePage_WIPRecordList=By.xpath(homePage_WIPRecordListXpath);
	public static By homePage_ISBNsearchbox=By.id(homePage_ISBNsearchboxXpath);
	public static By homePage_ISBNsearchArchive=By.xpath(homePage_ISBNsearchArchiveXpath);
	public static By homePage_ISBNArchiveSearchButton=By.xpath(homePage_ISBNArchiveSearchButtonXpath);
	public static By homePage_ViewPublication=By.xpath(homePage_ViewPublicationXpath);
	public static By ViewPublicationISBN=By.xpath(ViewPublicationISBNXpath);
	public static By ViewPublicationSearch=By.xpath(ViewPublicationSearchXpath);
	public static By homePage_FilterResult=By.xpath(homePage_FilterResultXpath);
	public static By homePage_WIPISBNcheckbox=By.xpath(homePage_WIPISBNcheckboxXpath);
	public static By ViewPublicationDelete=By.xpath(ViewPublicationDeleteXpath);
	public static By ViewPublicationDeleteConfirm=By.xpath(ViewPublicationDeleteConfirmXpath);
	public static By DeleteMsg=By.id(DeleteMsgXpath);
	public static By ViewPublicationMouseOver=By.xpath(ViewPublicationMouseOverXpath);
	public static By ViewPublicationCheckBox=By.xpath(ViewPublicationCheckBoxXpath);
	
	public static By homePage_WIPISBNlink=By.xpath(homePage_WIPISBNlinkXpath);
	public static By homePage_VendorCreatebutton=By.id(homePage_VendorCreatebuttonXpath);
	public static By homePage_WIPRecordDeletebutton=By.id(homePage_WIPRecordDeletebuttonXpath);
	public static By homePage_WIPRecordDeleteConfirmPopUp=By.xpath(homePage_WIPRecordDeleteConfirmPopUpXpath);
	public static By homePage_Vendorlist=By.cssSelector(homePage_VendorlistXpath);
	public static By homePage_VendorName=By.partialLinkText(homePage_VendorNameXpath);
	public static By homePage_VendorSaveButton=By.id(homePage_VendorSaveButtonXpath);
	public static By homePage_VendorSendRequest=By.id(homePage_VendorSendRequestXpath);
	public static By homePage_VendorSendRequestContinuePopUp=By.xpath(homePage_VendorSendRequestContinuePopUpXpath);
	public static By homePage_VendorNamecheckbox=By.xpath(homePage_VendorNamecheckboxXpath);
	public static By homePage_VendorNameDeletebutton=By.id(homePage_VendorNameDeletebuttonXpath);
	public static By homePage_VendorNameDeleteYesPopUpbutton=By.xpath(homePage_VendorNameDeleteYesPopUpbuttonXpath);
	public static By homePage_VendorStatus=By.xpath(homePage_VendorStatusXpath);
	public static By homePage_VendorContinue=By.id(homePage_VendorContinueXpath);
	public static By receivedPublication_XMLarrow=By.xpath(receivedPublication_XMLarrowXpath);
	public static By receivedPublication_EditMetaData=By.xpath(receivedPublication_EditMetaDataXpath);
	public static By receivedPublication_BussinessUnitEditMetaDataPopUp=By.id(receivedPublication_BussinessUnitEditMetaDataPopUpXpath);
	public static By receivedPublication_SaveEditMetaDataPopUp=By.xpath(receivedPublication_SaveEditMetaDataPopUpXpath);
	public static By receivedPublication_OKEditMetaDataPopUp=By.xpath(receivedPublication_OKEditMetaDataPopUpXpath);
	public static By receivedPublication_ApproveBookXML=By.linkText(receivedPublication_ApproveBookXMLXpath);
	public static By receivedPublication_OKApproveBookXMLPopUp=By.xpath(receivedPublication_OKApproveBookXMLPopUpXpath);
	public static By receivedPublication_ApproveAllChapters=By.linkText(receivedPublication_ApproveAllChaptersXpath);
	public static By receivedPublication_Assign=By.id(receivedPublication_AssignXpath);
	public static By receivedPublication_AssignOk=By.xpath(receivedPublication_AssignOKXpath);
	public static By receivedPublication_PublishArchive=By.id(receivedPublication_PublishArchiveXpath);
	public static By receivedPublication_PublishArchivePosttostagingnow=By.xpath(receivedPublication_PublishArchivePosttostagingnowXpath);
	public static By receivedPublication_PublishArchivePublishonLivenow=By.xpath(receivedPublication_PublishArchivePublishonLivenowXpath);
	
	public static By BPAUserName=By.name(BPAUserNameXpath);
	public static By BPAPassword=By.name(BPAPasswordXpath);
	public static By BPASignIn=By.xpath(BPASignInXpath);
	public static By BPALogOut=By.xpath(BPALogOutXpath);
	
	// CCH application
	
	public static By CCHuser = By.xpath(CCHuserid);
    public static By CCHpassword = By.xpath(CCHpasswordid);
    public static By submitCCH_login = By.xpath(submitCCH_loginid);
    public static By homePage_Transferlogslink = By.linkText(homePage_TransferlogslinkXpath);
    public static By Transferlogs_LabelISBNinput = By.xpath(Transferlogs_LabelISBNinputXpath);
    public static By Transferlogs_onPeriod = By.xpath(Transferlogs_onPeriodXpath);
    public static By Transferlogs_Searchbutton = By.xpath(Transferlogs_SearchbuttonXpath);
    public static By Transferlogs_Destination = By.xpath(Transferlogs_DestinationXpath);
    public static By Transferlogs_Destinationmsg = By.xpath(Transferlogs_DestinationmsgXpath);
    
 // DSS Application
    public static By LIT_oBook_Automation = By.xpath(LIT_oBookXpath);
    public static By DSSSearchResult = By.xpath(DSSSearchResultXpath);
    public static By DSSViewDetails = By.xpath(DSSViewDetailsXpath);
    public static By DSSSafeDelete = By.xpath(DSSSafeDeleteXpath);
    public static By DSSStatus = By.xpath(DSSStatusXpath);
    public static By DSSLicenseFilter = By.xpath(DSSLicenseFilterXpath);
    public static By DSSLicenseName = By.xpath(DSSLicenseNameXpath);
    public static By LIT_MRW_RELEASE_TEST = By.xpath(LIT_MRWXpath);
    public static By LIT_MRW_RELEASE_TEST_QA = By.xpath(LIT_MRWQAXpath);    
    
    
    
    
    
    //---------------------------------End of BPA Section--------------------------------------------------------	
	
	//---------------------------------Start of Literatum Processing Queue Section----------------------------------------------------------------------
	public static By LitGroup=By.xpath(LitGroupXpath);
	public static By LitGroup_Book=By.partialLinkText(LitGroupBookXpath);
	public static By LitGroupDOI=By.xpath(LitGroupDOIXpath);
	public static By loginUser=By.id(loginUserXpath);
	public static By loginPass=By.id(loginPassXpath);
	public static By UniversalDOISearch=By.xpath(UniversalDOISearchXpath);
	public static By DOISearch=By.xpath(DOISearchXpath);
	public static By ClickonAction=By.xpath(ClickonActionXpath);
	public static By ClickonActionMove=By.xpath(ClickonActionMoveXpath);
	public static By workflowstate=By.xpath(workflowstateXpath);
	public static By CATRefresh=By.xpath(CATRefreshXpath);
	public static By ContentSelectandClick=By.xpath(ContentSelectandClickxpath);
	public static By CATMove=By.xpath(CATMoveXpath);
	public static By CATMoveOkDialog=By.xpath(CATMoveOkDialogXpath);
	public static By LitProcessingQueue=By.xpath(LitProcessingQueueXpath);
	public static By LitGroupSearchResult=By.xpath(LitGroupSearchResultXpath);
	public static By LitGroupSearchClick=By.xpath(LitGroupSearchClickXpath);
	public static By LitGroupDelete=By.xpath(LitGroupDeleteXpath);
	public static By LitGroupDeletePopup=By.xpath(LitGroupDeletePopupXpath);
	public static By LitGroupDeletePopupMRW=By.xpath(LitGroupDeletePopupMRWXpath);
	public static By LitSeries=By.xpath(LitSeriesXpath);
	public static By LitJournalCode=By.xpath(LitJournalCodeXpath);
	public static By LitJournalTable=By.xpath(LitJournalTableXpath);
	public static By LitClickonJournalCode=By.xpath(LitClickonJournalCodeXpath);
	public static By LitIssueInProgress=By.xpath(LitIssueInProgressXpath);
	public static By LitIssueInProgressSubmit=By.xpath(LitIssueInProgressSubmitXpath);
	public static By LitMRWItemDOI=By.xpath(LitMRWItemDOIXpath);
	public static By CATRefreshMRW=By.xpath(CATRefreshMRWXpath);
	public static By LitGroupSearchMRWClick=By.xpath(LitGroupSearchMRWClickXpath);
	
	
	
	//---------------------------------End of Literatum Processing Queue Section----------------------------------------------------------------------
	
	// Home Page
	public By wileyOnlineLibaryImage = By.xpath(wileyOnlineLibaryImageXpath);
	
	// Search 
	public By searchText = By.id(searchTextXpath);
	public By allcontent = By.id(allcontentXpath);
	public By searchButton = By.id(searchButtonXpath);
	public By searchResultPage = By.xpath(searchResultPageXpath);
	public By publicationLink = By.xpath(publicationLinkXpath);
	
	
	//Search Result Page
	public By journalFilterList = By.xpath(journalFilterListXpath);
	public By booksFilterList = By.xpath(booksFilterListXpath);
	public By referenceWorkFilterList = By.xpath(referenceWorkFilterListXpath);
	public By bookSeriesFilterList = By.xpath(bookSeriesFilterListXpath);
	public By databaseFilterList = By.xpath(databaseFilterListXpath);
	public By labprotocolFilterList = By.xpath(labprotocolFilterListXpath);
	public By reomvoeFilter = By.xpath(reomvoeFilterXpath);
	public By refworkFilterListNoLink = By.xpath(refworkFilterListNoLinkXpath);
	

	public By view120 = By.xpath(view120Xpath);
	public By view2140 = By.xpath(view2140Xpath);
	public By view4160 = By.xpath(view4160Xpath);
	public By view6180 = By.xpath(view6180Xpath);
	public By viewnext = By.xpath(viewnextXpath);
	public By viewprev = By.xpath(viewprevXpath);
	
	public By Contenttype = By.xpath(ContenttypeXpath);
	public By Contentvalue = By.xpath(ContentvalueXpath);
	public By noResult = By.xpath(noresultfoundXpath);

	
	
	//Login Page
    public static By usernameLocator = By.xpath(UserName_xpath);
    public static By passwordLocator = By.xpath(Password_xpath);
    public By logout = By.xpath(logout_xpath);
    public static By loginButtonLocator = By.xpath(Login_xpath);
    public By loginoverlay = By.xpath(loginoverlay_xpath);
    public static By loginchecker=By.xpath(loginchecker_xpath);
    public static By usernameLocator1 = By.xpath(UserName_xpath1);
  
    //Journal Page
    
    public By JournalTools = By.xpath(JournalToolsxpath);
    public By AALink = By.xpath(AALinkxpath);
    public By RequestPermissionLink = By.xpath(RequestPermissionLinkxpath);
    public By requestpermissionSearchresult = By.xpath(requestpermissionSearchresultxpath);
    public By selectcheckboxsearchresult = By.xpath(selectcheckboxsearchresultxpath);
    public By savetoprofilebtn = By.xpath(savetoprofilebtnxpath);
    public By savetomyprofile = By.xpath(savetomyprofilexpath);
    public static By clickupdate = By.xpath(clickupdatexpath);
    
    
    //Myprofile
    
    public static By myprofilelink = By.xpath(myprofilelinkxpath);
    public static By myprofilelinkcheck = By.xpath(myprofilelinkcheckxpath);
    public By savedarticles = By.xpath(savedarticlesxpath);
    public By selectAllCheckBox = By.xpath(selectAllCheckBoxxpath);
    public By deletearticlebtn = By.xpath(deletearticlebtnxpath);
    public By requestpermissioninmyprofile = By.xpath(requestpermissioninmyprofilexpath);
    public static By checkmyaccount = By.xpath(checkmyaccountxpath);
    public By savedpublications = By.xpath(savedpublicationsxpath);
    public By referenceworkinmyprofile = By.xpath(referenceworkinmyprofilexpath);
    public By deletepublicationbtn = By.xpath(deletepublicationbtnxpath);
    public By subscriptionaccesslink = By.xpath(subscriptionaccesslinkxpath);
    public By subscriptionaccesscustid = By.xpath(subscriptionaccesscustidxpath);
    public By subscriptionaccessaccesscode = By.xpath(subscriptionaccessaccesscodexpath);
    public By subscriptionsubmit = By.xpath(subscriptionsubmitxpath);
    
    //Integration Check for Password Policy
    public static By clickAS2Check=By.id(clickAS2Checkid);
    public static By clickNext=By.xpath(clickNextxpath);
    public static By clickMyProfile=By.xpath(clickMyProfile_xpath);
    
    public static By as2LoginLinkbtn=By.xpath(as2LoginLinkbtn_xpath);
    public static By as2loginEmail=By.id(as2loginEmailid);
    public static By as2loginPWD=By.id(as2loginPWDid);
    public static By as2Loginbtn=By.id(as2Loginbtnid);
    public static By as2Myprofilelocator=By.xpath(as2Myprofilelocator_xpath);
	public static By customerdropdwn=By.id(customerdropdwnid);
    public static By userStatusdropdown=By.id(userStatusdropdownid);
    public static By loginErrMsg=By.xpath(loginErrMsg_xpath);
    public static By as2AreaOfInterest=By.xpath(as2AreaOfInterest_xpath);
    public static By as2AreaOfInterestlist=By.xpath(as2AreaOfInterestlist_xpath);
    
    //Arka
    //Literatum Homepage
    public static By homepagemove= By.xpath(homepagemovexpath);
    public static By checkFeatured= By.xpath(checkFeaturedxpath);
    public static By checkImagesrc= By.xpath(checkImagesrcxpath);
    public static By browseBysubject= By.xpath(browseBysubjectxpath);
    public static By checksubjectlist= By.xpath(checksubjectlistxpath); 
    public static By searchvalue= By.xpath(searchvaluexpath); 
    public static By searchsubmit= By.xpath(searchsubmitxpath); 
    public static By checkthevalue= By.xpath(checkthevaluexpath);  
    public static By countthevalue= By.xpath(countthevaluexpath); 
    public static By clickIucr= By.xpath(clickPublicationxpath); 
    public static By clickIcurContent= By.xpath(clickIcurContentxpath);
    
    
    
    //Literatum Journal Homepage
    public static By clickJournal= By.xpath(clickJournalxpath);
    public static By checkJournal= By.xpath(checkJournalxpath);
    public static By clickJournalTitle= By.xpath(clickJournalTitlexpath);
    public static By issueFirstPublishDate= By.xpath(issueFirstPublishDatexpath);
    public static By homepagemovejournal= By.xpath(homepagemovejournalxpath);
    public static By checkmetadaISSN= By.xpath(checkmetadaISSNxpath);
    public static By checksubject= By.xpath(checksubjectxpath);
    public static By searchtextbox = By.id(searchtextboxid);
    public static By searchtextbox1 = By.id(searchtextboxid1);
    public static By SearchDropDownValue = By.className(SearchDropDownValueclassName);
    public static By autosuggestionbox = By.id(autosuggestionboxid);
    public static By autosuggestionboxelement = By.xpath(autosuggestionboxelementxpath);
    public static By clickvolumeissue= By.xpath(clickvolumeissuexpath);
    public static By checkvolumeissue= By.xpath(checkvolumeissuexpath);
    public static By clickissuerange= By.xpath(clickissuerangexpath);
    public static By checkissueyear= By.xpath(checkissueyearxpath);
    public static By clcikbrowsearticle= By.xpath(clcikbrowsearticlexpath);
    public static By clickAllIssues1= By.xpath(clickAllIssuesxpath);
    public static By clickAllIssues= By.cssSelector(clickAllIssuescss);
    public static By clickVolume= By.xpath(clickVolumexpath);
    public static By scrollPage= By.xpath(scrollPagexpath);
    public static By clickFullText= By.xpath(clickFullTextxpath);
    public static By journalname= By.xpath(journalnamexpath);
    public static By advSearchLink = By.className(advSearchLinkclassName);
    public static By advSearchTextBox1 = By.id(advSearchTextBox1xpath);
    public static By advsearchsearchoption = By.id(advsearchsearchoptionid);
    public static By submitButton = By.xpath(submitButtonclass);
    public static By submitButtonHome = By.className(submitButtonhome);
    public static By selectclick = By.className(selectclickclass);
    public static By advSearchLinkheader = By.partialLinkText(advSearchLinkheaderText);
    public static By citationSearchLinkheader = By.partialLinkText(citationSearchLinkheaderText);
    public static By citationSearchTextBox1 = By.name(citationSearchTextBox1name);
    public static By citationYearTextBox = By.name(citationYearTextBoxname);
    public static By citationVolumeTextBox = By.name(citationVolumeTextBoxname);
    public static By citationIssueTextBox = By.name(citationIssueTextBoxname);
    public static By CitationSearchPageValues = By.className(CitationSearchPageValuesclassName);
    public static By submitButtonCitation = By.xpath(submitButtonCitationclass);
    public static By SaveSearchOption = By.id(SaveSearchOptionid);
    public static By SaveSearchPopup = By.id(SaveSearchPopupid);
    public static By SaveSearchLoginOption = By.xpath(SaveSearchLoginOptionXpath);
    public static By searchItem = By.xpath(searchItemClass);
    public static By pdfLink = By.partialLinkText(pdfLinkText);
    public static By clickbook= By.xpath(clickBookxpath);
    public static By checkbook= By.xpath(checkBookxpath);
    public static By InstituteLogin = By.xpath(InstituteLoginxpath);
    public static By InstitutionalAdmin = By.xpath(InstitutionalAdminxpath);
    public static By IPRanges=By.xpath(IPRanges_xpath);
    public static By addDescription=By.xpath(addDescription_xpath);
    public static By ArticleSelect = By.xpath(ArticleSelectxpath);
    public static By permissions=By.xpath(permissions_xpath); 
    public static By Addper=By.xpath(Addper_xpath);
    public static By Addemail=By.xpath(Addemail_xpath);
    public static By AddIP=By.xpath(AddIP_xpath);
    public static By AddIPrange=By.xpath(AddIPrange_xpath);
    
    
    
    // MRW Homepage
    public static By checkHomeTab= By.cssSelector(checkHomeTabid);
    public static By checkAboutTab= By.cssSelector(checkAboutTabid);
    public static By checkTOCTab= By.xpath(checkTOCTabid);
    public static By checkBBTTab= By.xpath(checkBBTTabid);
    public static By checkBAZTab= By.xpath(checkBAZTabid);
    public static By checkShareTab= By.cssSelector(checkShareTabid);
    public static By checkShareTabvalue= By.xpath(checkShareTabvalueid);
    //Literatum Abstract Page
    public static By clickAbstract= By.xpath(clickAbstractxpath);
    public static By checkAbstract= By.xpath(checkAbstractxpath);
    public static By clickBeforeAbstract= By.xpath(clickBeforeAbstractxpath);
    public static By checkTheAuthor1= By.xpath(checkTheAuthorxpath1);
    public static By checkTheAuthor2= By.xpath(checkTheAuthorxpath2);
    public static By checkMultilingual= By.xpath(checkMultilingualid);
    public static By clickonArticleLink= By.xpath(clickonArticleLinkclass);
    public static By BookHomeTOCtext = By.xpath(BookHomeTOCtextXpath);
    public static By JournalArticleLink = By.xpath(JournalArticleLinkxpath);
    public static By clickonArticleLink1= By.xpath(clickonArticleLinkclass1);
    
    
    //Literatum Book Chapter
    public static By clickBook1= By.xpath(clickBooktxpath);
    public static By checkBook1= By.xpath(checkBooktxpath);
    public static By clickonABook= By.xpath(clickonABookxpath);
    public static By checkmetadaISBN= By.xpath(checkmetadaISBNxpath);
    public static By clickonAchapter= By.xpath(clickonAchapterxpath);
    public static By checkchaptersection= By.xpath(checkchaptersectionxpath);
    public static By tableofcontent= By.xpath(tableofcontentxpath);
    
    //Literartum About this book
    public static By checkcontent= By.className(checkcontentclass);
    public static By checkshow= By.id(checkshowid);
    public static By checkshowallcontentsection= By.xpath(checkshowallcontentsectionxpath);
    
    //Literatum Book Search page
    public static By clicksearchbox= By.id(clicksearchboxid);
    public static By clicksearchdropdown= By.className(clicksearchdropdownclass);
    public static By clicksearchvalue= By.id(clicksearchvalueid);
    public static By checksearchbox= By.id(checksearchboxxpath);
    public static By searchsubmitbutton= By.xpath(searchsubmitbuttonxpath);
    public static By clickoutside= By.className(clickoutsidexpath);
    public static By clicksearchnewbox= By.id(clicksearchnewboxcss);
    
	//Readcube Page
    public static By ShareLinkArticle = By.id(ShareLinkArticleId);
    public static By ReadcubeSharing = By.xpath(ReadcubeSharingXpath);
	
   // clicksearchnewbox
    // Cochrane
    
    public By SearchTermField = By.xpath(SearchTermFieldxpath);
    
  //*[@id='pane-67065c09-4a88-49cd-934c-ac707951d35c1']/form/button
  //DSS
    public static By DSSUser = By.name(DSSUserName);
    public static By DSSPassword = By.name(DSSPasswordName);
    public static By button_login = By.className(button_login_class);
    public static By SearchBox = By.xpath(SearchBox_class);
    public static By SearchBtn = By.xpath(SearchBtn_xpath);
    public static By LogOut = By.linkText(LogoutLink);
    public static By TitleText = By.xpath(TitleTextXpath);
    public static By textAreaValue = By.tagName(textAreaValueTag);
    public static By Check_content_items = By.xpath(Check_content_items_xpath);
    public static By select_option = By.tagName(select_option_Tag);
    public static By Ignore_validation = By.xpath(Ignore_validation_ID);
    public static By Use_license_priority = By.xpath(Use_license_priority_ID);
    public static By Start_immediately = By.xpath(Start_immediately_ID);
    public static By Literatum_Issue_Test = By.xpath(Literatum_Issue_Test_xpath);
    public static By Deliver_btn = By.id(Deliver_btn_id);
 
   
    
    //Login WIP & UAT
    public static By userDetails = By.id(userDetails_id);
    public static By passwordDetails = By.id(passwordDetails_id);
    public static By loginDetails = By.id(loginDetails_id);
    
    //Compare WIP& UAT
    public static By clickOnSelection=By.xpath(clickOnSelection_xpath);
    public static By clickOnEntries=By.xpath(clickOnEntries_xpath);
    public static By clickOnSearch=By.xpath(clickOnSearch_xpath);
    
    
    //
	public static By selectionTab=By.xpath(selectionTabXpath);
	public static By numberJournal = By.xpath(numberJournalXpath);
	public static By searchField = By.xpath(searchFieldXpath);
	public static By view = By.xpath(viewXpath);
	public static By journalTitle = By.id(journalTitleId);
	
	public static By journalIssn = By.id(journalIssnId);
	public static By journalType = By.id(journalTypeId);
	public static By institutionalOnline = By.xpath(institutionalOnlineXpath);
	public static By institutionalPrintOnline = By.xpath(institutionalPrintOnlineXpath);
	public static By institutionalPrint = By.xpath(institutionalPrintXpath);
	public static By amountAmericasOnline = By.xpath(amountAmericasOnlineOnlyXpath);
	public static By amountUKOnline = By.xpath(amountUKOnlineOnlyXpath);
	public static By amountEuropeOnline =By.xpath(amountEuropeOnlineOnlyXpath);
	public static By amountROWOnline = By.xpath(amountROWOnlineOnlyXpath);
	public static By sapIssn = By.id(sapIssnId);
	public static By RelationshipID=By.id(RelationshipIDid);
	public static By amountAmericasPrintOnline = By.xpath(amountAmericasPrintOnlineXpath);
	public static By amountUKPrintOnline = By.xpath(amountUKPrintOnlineXpath);
	public static By amountEuropeOnlinePrintOnline = By.xpath(amountEuropeOnlinePrintOnlineXpath);
	public static By amountROWOnlinePrintOnline = By.xpath(amountROWOnlinePrintOnlineXpath);
	public static By amountAmericasPrint = By.xpath(amountAmericasPrintXpath);
	public static By amountUKPrint = By.xpath(amountUKPrintXpath);
	public static By amountEuropePrint = By.xpath(amountEuropePrintXpath);
	public static By amountROWPrint = By.xpath(amountROWPrintXpath);
	public static By tablePricingDetail = By.id(tablePricingDetailId);
	public static By environMentDetail = By.id(environMentDetailId);
	
	
	
	//
	
	//public static By bannerTitle = By.id(bannerTitleId);
    
    // ALM TO LIT
    public static By ALMUserEmailField = By.xpath(ALMUserEmailField_xpath);
	public static By ALMSearchUser=By.xpath(ALMSearchUser_xpath);
	public static By ALMClickSearchedUser=By.xpath(ALMClickSearchedUser_xpath);
    public static By ALMuser = By.id(ALMuserid);
    public static By ALMpassword = By.id(ALMPasswordid);
    public static By submitALM_login = By.id(submitALM_loginid);
    public static By custid= By.id(cust_id);
    public static By login=By.id(login_id);
    public static By insPassword=By.id(insPasswordid);
    public static By confirminspassword=By.id(confirminspasswordid);
    public static By senddate=By.id(senddateid);
    public static By sendmoddate=By.id(sendmoddateid);
    public static By descriptionrem=By.xpath(descriptionrem_xpath);
    public static By custname= By.id(custname_id);
    public static By maxuser= By.id(maxuser_id);
    public static By access= By.id(access_id);
    public static By societyURL= By.id(societyURL_id);
    public static By submitcustomer=By.xpath(submitcustomerxpath);
    public static By adminPassword=By.id(adminPasswordid);
    public static By adminConPassword=By.id(adminConPasswordid);
    public static By clickradio=By.xpath(clickradio_id);
    public static By setpassword=By.xpath(setpassword_id);
    public static By resetpassword=By.xpath(resetpassword_id);
    public static By clickresetpassword=By.xpath(clickresetpassword_id);
    public static By custValue= By.xpath(custValuexapth);
    public static By stateValue= By.xpath(stateValuexpath);
    public static By LITuser= By.id(LITuserid);
    public static By LITpassword = By.id(LITpasswordid);
    public static By submitLIT_login= By.name(submitLIT_loginname);
    public static By admin=By.xpath(adminxpath);
    public static By contentslice=By.xpath(contentslice_xpath);
    public static By License=By.xpath(License_xpath);
    public static By Address=By.xpath(Addressxpath);
    public static By accesstoken= By.xpath(accesstokenxpath);
    public static By tokenval= By.xpath(tokenvalxapth);
    public static By searchtoken= By.xpath(searchtokenxpath);
    public static By identi=By.xpath(identixpath);
    public static By license=By.xpath(licensexpath);
    public static By publicval= By.xpath(publicvalid);
    public static By publicIP=By.xpath(publicIP_xpath);
    public static By codeval=By.xpath(codeval_xpath);
    public static By prodcodeval=By.xpath(prodcodeval_xpath);
    public static By searchLicense=By.xpath(searchLicense_xpath);
    public static By search= By.xpath(searchxpath);
    public static By fetchDesc= By.xpath(fetchDescxpath);
    public static By emailuser= By.id(emailuser_id);
    public static By passworduser=By.id(passworduser_id);
    public static By confirmpassworduser=By.xpath(confirmpassworduser_id);
    public static By clickonImitate=By.xpath(clickonImitate_xpath);
    public static By clickspace=By.xpath(clickspace_xpath);
    public static By clickinsspace=By.xpath(clickinsspace_xpath);
    public static By checkOKContent=By.xpath(checkOKContent_xpath);
    public static By sendIP = By.xpath(sendIP_xpath);
    
    public static By clickonpdf=By.xpath(clickonpdf_xpath);
    public static By clickdownloadfullbook = By.xpath(downloadfullbook_xpath);
    public static By clickonchapter= By.xpath(clickonchapter_xpath);
    public static By clickondownload=By.xpath(clickondownload_xpath);
    public static By aboutthisbook=By.xpath(aboutthisbook_xpath);
    
    public static By descriptionIP=By.xpath(descriptionIP_xpath);
    public static By minIP=By.xpath(minIP_xpath);
    public static By maxIP=By.xpath(maxIP_xpath);
    public static By create=By.xpath(create_xpath);
    //Instituion Address update in LIT
    public static By clickonAddress=By.xpath(clickonAddress_xpath);
    public static By address1=By.xpath(address1xpath);
    public static By city1=By.xpath(cityxpath);
    public static By state1=By.xpath(statexpath);
    public static By zipcode1=By.xpath(zipcodexpath);
    public static By phone1=By.xpath(phonexpath);
    
    //add affiliation
    public static By addaffiliation= By.xpath(addaffiliationxpath);
    public static By addisvisible= By.xpath(addisvisiblexpath);
    
    public static By clickonline=By.xpath(clickonline_xpath);
    public static By clickonline1=By.xpath(clickonline1_xpath);
    public static By addafftosoc=By.xpath(addafftosocxpath); 
    
    public static By removedata=By.xpath(removedata_xpath);
    
    //License ID
    public static By LicenseID= By.id(LicenseID_id);
    public static By description=By.id(description_id);
    public static By description1=By.id(description1_id);
    public static By tokens=By.id(tokens_id);
    public static By contentStartDate=By.id(contentStartDate_id);
    public static By selectstartdate=By.xpath(startdate);
    public static By contentEndDate=By.id(contentEndDate_id);
    public static By selectenddate=By.xpath(enddate);
    public static By selectenddate1=By.xpath(enddate1);
    public static By selectarrow=By.id(selectarrow_id);
    public static By selectarrow1=By.id(selectarrow1_id);
    public static By validFromDate=By.id(validFromDate_id);
    public static By validEndDate=By.id(validEndDate_id);
    public static By addProduct=By.xpath(addProduct_xpath);
    public static By productID=By.id(productID_id);
    public static By searchproduct=By.id(search_id);
    public static By newrow=By.xpath(newrow_xpath);
    public static By addSelected=By.xpath(addSelected_xpath);
    public static By selectok=By.id(selectok_id);
    public static By submitLicense=By.id(submitLicense_id);
    public static By modifyLicense=By.xpath(modifyLicense_xpath);
    public static By tranID=By.id(tranID_id);
    public static By fullID=By.id(fullID_id);
    public static By deletelicense=By.xpath(deletelicense_xpath);
    public static By deleteok=By.id(deleteok_id);
    public static By LicenseID_id_search = By.id(LicenseID_id_search_id);
    public static By searchLicenseButton = By.xpath(searchLicenseButton_xpath);
    public static By LicenseID_token_count = By.xpath(LicenseID_token_count_xpath);
    
    //Product
    public static By createProductID=By.id(createProductID_id);
    public static By productDescID=By.id(productDescID_id);
    public static By searchProd=By.id(searchProd_id);
    public static By clickonprodid=By.id(clickonprodid_id);
    public static By modifyproduct=By.xpath(modifyproduct_xpath);
    public static By modProdDesc=By.id(modProdDesc_id);
    public static By addContent=By.xpath(addContent_xpath);
    public static By removeContent=By.xpath(removeContent_xpath);
    public static By electronicdet=By.id(electronicdet_id);
    public static By contentsearch=By.id(contentsearch_id);
    public static By selcontentrow=By.xpath(selcontentrow_xpath);
    public static By addSelectRow=By.xpath(addSelectRow_xpath);
    public static By addOkContent=By.id(addOkContent_xpath);
    public static By deleteOKContent=By.xpath(deleteOKContent_xpath);
    public static By deleteproduct=By.xpath(deleteproduct_xpath);
    public static By deleteOKProduct=By.id(deleteOKProduct_id);
    
    //IP Authentication
    public static By clickonAuth=By.xpath(clickonAuth_xpath);
    public static By clickonIP=By.xpath(clickonIP_xpath);
    public static By clickonReg=By.xpath(clickonReg_xpath);
    public static By clickonModify=By.xpath(clickonModify_xpath);
    public static By addIP=By.id(addIP_id);
    public static By deleteIP=By.id(deleteIP_id);
    public static By clickonEnterIP=By.xpath(clickonEnterIP_xpath);
    public static By enterIP=By.id(enterIP_id);
    public static By readyToSubmit=By.xpath(readyToSubmit_xpath);
    
    
    //subscription affiliation
    public static By profilename=By.xpath(profilename_xpath);
    public static By onAccount=By.xpath(onAccount_xpath);
    public static By subcriptionacc=By.xpath(subcriptionacc_xpath);
    public static By customerID=By.id(customerID_id);
    public static By accessID=By.id(accessID_id);
    public static By accessSubmit=By.xpath(accessSubmit_xpath);
    
    
    //Reg
    public static By clickonMembers=By.xpath(clickMemberxpath);
    
    // Modify Customer ALM
    public static By customeID= By.id(customeID_id);
    public static By clickonsearch= By.id(clickonsearch_xpath);
    //public static By clickoncustid= By.id(clickoncustid_id);
    public static By clickoncustid= By.xpath(clickoncustid_xpath);
    public static By clickonAttribute=By.xpath(clickonAttribute_xpath);
    public static By clickmanageLicnese=By.xpath(clickmanageLicnese_xpath);
    public static By clickAddLicense=By.xpath(clickAddLicense_xpath);
    public static By clickreset= By.xpath(clickreset_xpath);
    public static By clickmodify= By.xpath(clickmodify_xpath);
    public static By clickdelete= By.xpath(clickdelete_xpath);
    public static By firstName= By.xpath(firstName_id);
    public static By secondName= By.xpath(secondName_id);
    public static By email= By.xpath(email_id);
    public static By firstNameper= By.xpath(firstNameper_id);
    public static By secondNameper= By.xpath(secondNameper_id);
    public static By emailper= By.xpath(emailper_id);
    public static By address= By.xpath(address_xpath);
    public static By state= By.xpath(state_xpath);
    public static By city= By.xpath(city_xpath);
    public static By street=By.xpath(street_xpath);
    public static By pincode=By.xpath(pincode_xpath);
    public static By succesfull=By.xpath(succesfull_xpath);
    public static By checkrownumber = By.xpath(checkrownumber_xpath);
    
    //TNC
    public static By addTNCFirstName=By.id(addTNCFirstNameid);
    public static By addTNCLastName=By.id(addTNCLastNameid);
    public static By addTNCEmail=By.id(addTNCEmailid);
    public static By addPhone=By.id(addPhoneid);
    
    //Add affiliation
    public static By clickonView=By.xpath(clickonView_xpath);
    public static By clickonModUser=By.xpath(clickonModUser_xpath);
    public static By addEmail=By.id(addEmailid);
    public static By clickonEnterEmail=By.xpath(clickonEnterEmail_xpath);
    public static By enterEmail=By.id(enterEmailid);
    public static By sendEmail=By.xpath(sendEmail_xpath);
    public static By setverify= By.xpath(setverify_xpath);
    public static By sendLID=By.xpath(sendLID_xpath);
    public static By readyToSubmitemail=By.xpath(readyToSubmitemailxpath);
    public static By deleteEmail=By.id(deleteEmailid);
    public static By LicenseID_Lit = By.xpath(LicenseID_Lit_xpath);
    public static By Token_Lit = By.xpath(Token_Lit_xpath);
    
    //Add Personal User
    public static By sendpassword=By.xpath(sendpassword_xpath);
    public static By sendfirst=By.xpath(sendfirst_xpath);
    public static By sendlast=By.xpath(sendlast_xpath);
    public static By clickonCreate=By.xpath(clickonCreate_xpath);
    public static By sendEmailcreated=By.id(sendEmailcreated_id);
    public static By clickonEmail=By.id(clickonEmail_id);
  //  public static By clickonEmail=By.xpath(clickonEmail_xpath);
    public static By emailValue=By.xpath(emailValue_xpath);
    public static By clickonUpdate=By.xpath(clickonUpdate_xpath);
    public static By clickonYes=By.xpath(clickonYes_xpath);
    public static By sendfirstupdate=By.xpath(sendfirstupdate_xpath);
    public static By updatePassword=By.xpath(updatePassword_xpath);
    
    //Add address 
    public static By clickonUser= By.xpath(clickonUser_xpath);
    public static By updateDetails=By.xpath(updateDetails_xpath);
    public static By addDetail1=By.id(addDetail1_id);
    public static By addCity=By.id(addCity_id);
    public static By SubmitAddress=By.name(SubmitAddress_name);
    
    /*Application Name= JQA QA Gateway 
	 * Page Name= JQA Home Page
	 Designed by Janmejaya Sahu*/
    
    public static By JQAQALoginpage=By.xpath(JQA_QA_Loginpage_xpath);
    public static By JQAQAusername=By.xpath(JQA_QA_username_xpath);
    public static By JQAQApassword = By.xpath(JQA_QA_password_xpath);
    public static By JQAQAlogin = By.xpath(JQA_QA_btnlogin_xpath);
    public static By JQAQAHomepage=By.xpath(JQA_QA_Homepage_xpath);
    public static By JQAQAUploadPackage=By.xpath(JQA_QA_uploadPackage_xpath);
    public static By msguploadSuccessful=By.xpath(upload_Successful_xpath);
    public static By btnUpload=By.xpath(btn_Upload_xpath);
    public static By UploadStatus=By.xpath(Upload_Status_xpath);
    public static By deliveredStatus=By.xpath(delivered_Status_xpath);
    public static By chkenforceVisualQACheckBox=By.xpath(chkenforceVisualQACheckBox_xpath);

	/*Application Name= JQA UI  
	 * Page Name= JQA UI Page
	 Designed by Janmejaya Sahu*/    
    
    public static By tabAdmin=By.xpath(tab_Admin_xpath);
    public static By subtabManageContent=By.xpath(subtab_ManageContent_xpath);
    public static By searchLevel=By.xpath(search_Level_xpath);
    public static By txtJournalId=By.xpath(txt_JournalId_xpath);
    public static By btnSearch=By.xpath(btn_Search_xpath);
    public static By searchResulttable=By.xpath(search_Resulttable_xpath);
    public static By articleDoi=By.xpath(article_DOI_xpath);
    public static By tabCADashboard = By.xpath(tabCADashboard_xpath);
    public static By tabpreviewContent = By.xpath(tabpreviewContent_xpath);
    public static By tabpreviewContent1 = By.xpath(tabpreviewContent1_xpath); 
    public static By tabPreviewContent_PubArticle = By.xpath(tabPreviewContent_PubArticle_xpath);
    public static By btnWarningClose = By.xpath(btnWarningClose_xpath);
    public static By chkbox_SelectAll = By.xpath(chkbox_SelectAll_xpath);
    public static By btnViewinPlatform = By.xpath(btn_viewInPlatform_xpath);
    public static By btn_viewInPlatformPubArticles = By.xpath(btn_viewInPlatformPubArticles_xpath);
    public static By btnApprove = By.xpath(btnApprove_xpath);
    public static By popup_Confirmapprove = By.xpath(popup_Confirmapprove_xpath);
    public static By btnOk_Confirmapprove = By.xpath(btnOK_Confirmapprove_xpath);
    public static By lnkViewFullSize = By.xpath(lnk_ViewFullSize_xpath);
    public static By journalListarticle = By.xpath(journalListarticle_xpath);
    public static By btnSetEmbargo = By.xpath(btnSetEmbargo_xpath);
    public static By embargoForm = By.xpath(embargoForm_xpath);
    public static By iconCalender = By.xpath(iconCalender_xpath);
    public static By btn_ConfirmDate = By.xpath(btn_ConfirmDate_xpath);
    public static By dateReflected = By.xpath(dateReflected_xpath);
    public static By tabPublishedArticles = By.xpath(tab_PublishedArticles_xpath);
    public static By txt_Journalid = By.xpath(txt_Journalid_xpath);
    public static By btnSearchPublishArticle = By.xpath(btnSearch_xpath);
    public static By btnSearchJrnalId_ActLog = By.xpath(btnSearchJrnalId_ActLog_xpath);
    public static By CMS_PublicationStatus = By.xpath(CMS_PublicationStatus_xpath);
    public static By contentGenerationStatus = By.xpath(contentGenerationStatus_xpath);
    public static By contentBundleLinkingStatus = By.xpath(contentBundleLinkingStatus_xpath);
    public static By CMSSendPublicationStatus = By.xpath(CMSSendPublicationStatus_xpath);
    public static By atyponActionStatus = By.xpath(atyponActionStatus_xpath);
    public static By chkboxJrnalId_PubArticles = By.xpath(chkboxJrnalId_PubArticles_xpath);
    public static By ActivityLog= By.xpath(ActivityLog_xpath); 
    public static By authorManuscript_PubArticles= By.xpath(authorManuscript_PubArticles_xpath);
    public static By txtEmbargoDate = By.xpath(txtEmbargoDate_xpath);
    public static By contentGenerationMessage = By.xpath(contentGenerationMessage_xpath);
    public static By contentGenerationProcessingMessage= By.xpath(contentGenerationProcessingMessage_xpath);
    public static By contentGenerationError_type= By.xpath(contentGenerationError_type_xpath);
    public static By CMS_Publication_deposit_Message= By.xpath(CMS_Publication_deposit_Message_xpath);
    public static By Interface_generation= By.xpath(Interface_generation_xpath);
    /*Application Name= DSS QA 
	 * Page Name= DSS QA Page
	 Designed by Janmejaya Sahu*/
    
    public static By DSSQAusername=By.xpath(DSS_QA_Username_xpath);
    public static By DSSQApassword=By.xpath(DSS_QA_Password_xpath);
    public static By DSSQAlogin = By.xpath(DSS_QA_btnlogin_xpath);
    public static By menuMonitor = By.xpath(menu_Monitor_xpath);
    public static By submenuSearchContent = By.xpath(submenu_SearchContent_xpath);
    public static By searchContentPage = By.xpath(searchContent_page_xpath);
    public static By txtContentId = By.xpath(txt_ContentId_xpath);
    public static By btnSearchId = By.xpath(btn_SearchId_xpath);
    public static By tableSearchContentId = By.xpath(table_SearchContentId_xpath);
    public static By lnkAddtoDelivery = By.xpath(lnk_AddtoDelivery_xpath);
    public static By deliverysuccessfulpopupmsg = By.xpath(successfulPopupmsg_xpath);
    public static By menu_Delivery = By.xpath(menu_Delivery_xpath);
    public static By submenuManualDelivery = By.xpath(submenu_ManualDelivery_xpath);
    public static By deliverContentPage = By.xpath(deliverContent_Page_xpath);
    public static By txtContentType = By.xpath(txt_ContentType_xpath);
    public static By chk_literatumAA = By.xpath(chk_literatumAA_xpath);
    public static By chkLiteratum_AA_Test = By.xpath(chk_Literatum_AA_Test_xpath);
    public static By chk_Literatum_AA_EVStag = By.xpath(chk_Literatum_AA_EVStag_xpath);
    public static By radbtnShowlicense = By.xpath(radbtn_Showlicense_xpath);
    public static By chkLiteratum_Issue_Test = By.xpath(chk_Literatum_Issue_Test_xpath);
    public static By chk_LiteratumIssueTest = By.xpath(chk_LiteratumIssueTest_xpath);
    public static By issueDoi = By.xpath(issueDoi_xpath);
    public static By btnDeliver = By.xpath(btn_deliver_xpath);
    public static By radbtnUseLicense = By.xpath(radbtn_UseLicense_xpath);
    public static By radbtn_ShowImmediately = By.xpath(radbtn_ShowImmediately_xpath);
    public static By submenuBulkDeliveries = By.xpath(submenu_BulkDeliveries_xpath);
    public static By bulkDeliveriesPage = By.xpath(bulkDeliveries_Page_xpath);
    public static By lnkView = By.xpath(lnk_View_xpath);
    public static By lnkViewTrackBulkDeliveries = By.xpath(lnk_ViewTrackBulkDeliveries_xpath);
    public static By lnkreceived = By.xpath(lnkreceived_xpath);
    public static By lnk_ViewParent = By.xpath(lnk_ViewParent_xpath);
    

	/*Application Name= Wiley Online Library 
	 * Page Name= Wiley Online Page
	 Designed by Janmejaya Sahu*/
    
    public static By lnkLoginRegister = By.xpath(lnkLoginRegister_xpath);
    public static By tabActivityLog = By.xpath(tabActivityLog_xpath);
    //public static By LiveFeed = By.xpath(LiveFeed_xpath);
    
    /*Application Name= Content Admin  
	 * Page Name= Content Admin Page
	 Designed by Janmejaya Sahu*/
    
    public static By CONTENTADMINusername=By.xpath(CONTENT_ADMIN_Username_xpath);
    public static By CONTENTADMINpassword = By.xpath(CONTENT_ADMIN_Password_xpath);
    public static By CONTENTADMINlogin = By.xpath(CONTENT_ADMIN_btnlogin_xpath);
    public static By tabProcessingQueue = By.xpath(tab_processingQueue_xpath);
    public static By txtContentMatches = By.xpath(txt_contentmatches_xpath);
    public static By tabItems = By.xpath(tab_items_xpath);
    public static By txtSearchDOI = By.xpath(txt_searchDOI_xpath);
    public static By btnRefreshView = By.xpath(btn_refreshview_xpath);
    public static By LiveFeed = By.xpath(LiveFeed_xpath);
    public static By lnkViewDetails = By.xpath(lnk_ViewDetails_xpath);
    public static By published = By.xpath(published_xpath);
    public static By status = By.xpath(status_xpath);
    public static By tabGroups = By.xpath(tab_Groups_xpath);
    public static By txtDOI_Groups = By.xpath(txt_DOI_xpath);
    public static By optDelete = By.xpath(opt_Delete_xpath);
    public static By deleteIssueDialogbox = By.xpath(deleteIssue_Dialogbox_xpath);
    public static By btnConfirmDelGroup = By.xpath(btn_ConfirmDelGroup_xpath);
    public static By issueTable = By.xpath(issueTable_xpath);
    public static By actionTab = By.xpath(actiontab_xpath);
    public static By actionList = By.xpath(actionList_xpath);
    public static By productiontxt = By.xpath(Production_xpath);
    public static By deleteArticleDialogbox = By.xpath(deleteArticle_Dialogbox_xpath);
    public static By btnConfirmDelItem = By.xpath(btn_ConfirmDelItem_xpath);
    public static By delScheduleDialogbox = By.xpath(del_Schedule_Dialogbox_xpath);
    public static By btnOk_delScheduleDialog = By.xpath(btn_Ok_delScheduleDialog_xpath);
    public static By leftPanel_CompltdStatus = By.xpath(leftPanel_CompltdStatus_xpath);
    public static By statusFull = By.xpath(statusFull_xpath);
    public static By statusComplete = By.xpath(statusComplete_xpath);
    public static By Action_Category= By.xpath(Action_Category_xpath);
    public static By Action_subtask= By.xpath(Action_subtask_xpath);
    public static By View_In_Browser= By.xpath(View_In_Browser_xpath);

    public static By statusEV=By.xpath(statusEV_xpath);
    public static By statusAA=By.xpath(statusAA_xpath);

    public static By statusearlyview = By.xpath(statusearlyview_xpath);

    public static By publishedNo = By.xpath(publishedNo_xpath);
    public static By publishedYes = By.xpath(publishedYes_xpath);

    public static By areaTextbox = By.xpath(areaTextbox_xpath);
    public static By workFlowState = By.xpath(workFlowState_xpath);
    public static By optMove = By.xpath(opt_Move_xpath);
    public static By moveIssueDialogbox = By.xpath(moveIssueDialogbox_xpath);
    public static By toAreaDropdwn = By.xpath(toAreaDropdwn_xpath);
    public static By moveWithDropdwn = By.xpath(moveWithDropdwn_xpath);
    public static By moveContentDropdwn = By.xpath(moveContentDropdwn_xpath);
    public static By btnMove = By.xpath(btn_Move_xpath);
    public static By areaStaging = By.xpath(area_Staging_xpath);
    public static By areaLive = By.xpath(area_Live_xpath);
    public static By moveScheduleDialog = By.xpath(moveScheduleDialog_xpath);
    public static By btnOK_moveScheduleDialog = By.xpath(btnOK_moveScheduleDialog_xpath);
    public static By articlenotfound = By.xpath(articlenotfound_xpath);
    
    public static By ArticlesTab = By.xpath(ArticlesTab_xpath);
    public static By addArticle = By.xpath(addArticle_xpath);
    public static By toAreaDropdwninArticle = By.xpath(toAreaDropdwninArticle_xpath);
    public static By moveContentDropdwninArticle = By.xpath(moveContentDropdwninArticle_xpath);
    public static By btnMoveArticle = By.xpath(btnMoveArticle_xpath);
    public static By moveArticleDialogbox = By.xpath(moveArticleDialogbox_xpath);
    public static By confirmMoveArticleDialogbox = By.xpath(confirmMoveArticleDialogbox_xpath);
    public static By btnOk_ArticleDialogbox = By.xpath(btnOk_ArticleDialogbox_xpath);
   
    //Article Select
    public static By SlotLicensesection = By.className(SlotLicensesection_className);
    public static By SlotLicenseConfirm = By.xpath(SlotLicenseConfirm_xpath);
    public static By SlotLicenseConfirmMob = By.xpath(SlotLicenseConfirmMob_xpath);
    
    
    //AS2
    public static By SecuritySection = By.xpath(SecuritySection_xpath);
    public static By ChangePassword = By.id(ChangePassword_id);
    public static By OldPassword = By.id(OldPassword_id);
    public static By NewPassword1 = By.id(NewPassword1_id);
    public static By NewPassword2 = By.id(NewPassword2_id);
    public static By SavePassword = By.id(SavePassword_id);
    public static By ConfirmPopUp = By.xpath(ConfirmPopUp_xpath);

    
    public static By loggedUser = By.id(loggedUser_id);
    public static By MyAccount = By.xpath(MyAccount_xpath);
    public static By ChangePWD = By.xpath(ChangePWD_xpath);

    /*public static By oldPassword = By.name(oldPassword_name);
    public static By newPassword_as = By.name(newPassword_name);*/
    
    public static By oldPassword = By.name(oldPasswordField_xpath);
    public static By newPassword_as = By.name(newPasswordField_xpath);

    public static By oldPasswordField = By.xpath(oldPasswordField_xpath);
    public static By newPasswordField = By.xpath(newPasswordField_xpath);

    public static By changePassSubmit = By.xpath(changePassSubmit_xpath);
    public static By updateEmailArrow = By.xpath(updateEmailArrow_xpath);
    public static By editButton = By.xpath(editButton_xpath);
    public static By primaryEmailField = By.xpath(primaryEmailField_xpath);
    public static By saveButton = By.xpath(saveButton_xpath);
    public static By closeModalWindow = By.xpath(closeModalWindow_xpath);
    public static By achOldPass = By.xpath(achOldPass_xpath);
    public static By achNewPass= By.xpath(achNewPass_xpath);
    public static By achSubmitButton = By.xpath(achSubmitButton_xpath);
    


 //Miscellaneous Latest
    
    public static By LitAppDOIClick=By.xpath(LitAppDOIClick_xpath);
    public static By LitAppItemsFound=By.xpath(LitAppItemsFound_xpath);
    public static By LitAppSearchButton=By.xpath(LitAppSearchButton_xpath);
    public static By LitAppSearchField=By.xpath(LitAppSearchField_xpath);
    public static By LitAppLoginLink=By.xpath(LitAppLoginLink_xpath);
    public static By LitAppUserId=By.xpath(LitAppUserID_xpath);
    public static By LitAppPassword=By.xpath(LitAppPassword_xpath);
    public static By LitAppLoginButton=By.xpath(LitAppLoginButton_xpath);
    public static By LitAppScroll=By.xpath(LitAppScroll_xpath);
    
    public static By loginlink=By.xpath(loginlink_xpath);
    public static By loginusernameLocator=By.xpath(loginusernameLocator_xpath);
    public static By loginpasswordLocator=By.xpath(loginpasswordLocator_xpath);
    public static By libadminloginbuttonlocator=By.xpath(loginbutton_xpath);
    public static By invalidloginmsg=By.xpath(invalidloginmsg_xpath);
    public static By instAdminNamelocator=By.xpath(instAdminName_xpath);
    public static By institutionaladminlocator=By.xpath(instAdministration_xpath);
    public static By ipRangelocator=By.name(ipRangelocator_name);
    public static By ipRangedesclocator=By.name(ipRangedesclocator_name);
    public static By submitIPRangeChangebuttonlocator=By.xpath(submitIPRangeChanges_xpath);
    public static By ipRangedetaillocator=By.xpath(ipRangedetaillocator_xpath);
    public static By ipRangetablelocator=By.xpath(ipRangetablelocator_xpath);
    public static By myAccountlocator=By.xpath(myAccountlocator_xpath);
    public static By changePWDlocator=By.xpath(changePWDlocator_xpath);
    public static By oldPWDlocator=By.xpath(oldPWDlocator_xpath);
    public static By newPWDlocator=By.xpath(newPWDlocator_xpath);
    public static By submitPWDbuttonlocator=By.xpath(submitPWDbuttonlocator_xpath);
    public static By PWDwindowclose=By.xpath(PWDwindowclose_xpath);
    public static By PWDchangemsg=By.xpath(PWDchangemsg_xpath);
    public static By logoutlocator=By.xpath(logoutbutton_xpath);
    public static By searchboxlocator=By.xpath(searchboxlocator_xpath);
    public static By searchbuttonlocator=By.xpath(searchbuttonlocator_xpath);
    public static By noofsearchfoundlocator=By.xpath(noofsearchfoundlocator_xpath);
    public static By searchedDOIlocator=By.xpath(searchedDOIlocator_xpath);
    public static By contentlinklocator=By.xpath(contentlinklocator_xpath);
    public static By adminemaillocator=By.xpath(adminemaillocator_xpath);
    public static By admincnfemaillocator=By.xpath(admincnfemaillocator_xpath);
    public static By updatebuttonlocator=By.xpath(updatebuttonlocator_xpath);
    public static By duplicateEmailmsg=By.xpath(duplicateEmailmsg_xpath);

    
    
    //Duplicate Email Latest
    
    public static By LitWebadminUsername=By.xpath(LitWebadminUsername_xpath);
    public static By LitWebadminPassword=By.xpath(LitWebadminPassword_xpath);
    public static By LitWebadminLoginButton=By.xpath(LitWebadminLoginButton_xpath);
    public static By LitWebadminAdminLink=By.xpath(LitWebadminAdminLink_xpath);
    public static By LitWebadminIdentitiesLink=By.xpath(LitWebadminIdentitiesLink_xpath);
    public static By LitWebadminPersonuserLink=By.xpath(LitWebadminPersonuserLink_xpath);
    public static By LitWebadminEmail=By.xpath(LitWebadminEmail_xpath);
    public static By LitWebadminStatescroll=By.xpath(LitWebadminStatescroll_xpath);
    public static By LitWebadminSearchbutton=By.xpath(LitWebadminSearchbutton_xpath);
    public static By LitWebadminPasswordscroll=By.xpath(LitWebadminPasswordscroll_xpath);
    public static By LitWebadminEmailedit=By.xpath(LitWebadminEmailedit_xpath);
    public static By LitWebadminComment=By.xpath(LitWebadminComment_xpath);
    public static By LitWebadminSearchedemail=By.xpath(LitWebadminSearchedemail_xpath);
    public static By LitWebadminEditbutton=By.xpath(LitWebadminEditbutton_xpath);
    public static By LitWebadminEditemail=By.xpath(LitWebadminEditemail_xpath);
    public static By LitWebadminOkbutton=By.xpath(LitWebadminOkbutton_xpath);
    public static By LitWebadminCustscroll=By.xpath(LitWebadminCustscroll_xpath);
    public static By LitWebadminUpdatebutton=By.xpath(LitWebadminUpdatebutton_xpath);
    public static By LitWebadminFinalConfirm=By.xpath(LitWebadminFinalConfirm_xpath);
    public static By LitWebadminSearchLink=By.xpath(LitWebadminSearchLink_xpath);
    public static By LitWebadminPublicId=By.xpath(LitWebadminPublicId_xpath);
    public static By LitWebadminSearchButton=By.xpath(LitWebadminSearchButton_xpath);
    public static By LitWebadminPersonUserClick=By.xpath(LitWebadminPersonUserClick_xpath);
    public static By LitWebadminDetailButton=By.xpath(LitWebadminDetailButton_xpath);
    
    public static By adminEmaillocator=By.xpath(adminEmaillocator_xpath);
    public static By Attributestablocator=By.xpath(Attributestablocator_xpath);
    public static By changePWDtablocator=By.xpath(changePWDtablocator_xpath);
    public static By manualchangelocator=By.xpath(manualchangelocator_xpath);
    public static By newPassword=By.xpath(newPassword_xpath);
    public static By confirmpassword=By.xpath(confirmpassword_xpath);
    public static By resetPWDbtn=By.xpath(resetPWDbtn_xpath);


} 

