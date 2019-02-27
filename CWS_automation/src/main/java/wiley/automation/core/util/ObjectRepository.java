package wiley.automation.core.util;

import org.openqa.selenium.By;


public class ObjectRepository extends VariableController{

//---------------------------------Start of BPA Section----------------------------------------------------------------------

		
    // BPA Home Page
		
	public static String wipPlusMenuXpath = "//*[@id='subHeader']/div[1]/a";
	public static String createWIPrecordXpath = "createTitleRecord";	
	public static String createNewTitleRecord_EnterISBNXpath = "ISBN";	
	public static String createNewTitleRecord_CreateButtonXpath = "//span[.='Create']";
	public String createNewTitleRecord_PubExistPopUpXpath = "ui-id-2";	
	public static String createNewTitleRecord_PubExistPopUp_CancelXpath = "Cancel";	
	public static String createNewTitleRecord_RelatedISBNPopUp_ContinueXpath = "//*[contains(text(), 'Continue')]";	
	public static String createNewTitleRecord_ColtraneMDPopUp_CreateXpath = "(//button[@type='button'])[6]";	
	public static String titleMsgXpath = "message";
	public static String homePage_WIPRecordListXpath ="//*[@id='leftMenuList']/li[1]/a";
	public static String homePage_ISBNsearchboxXpath = "wipfilterSearchISBN";
	public static String homePage_FilterResultXpath ="//a[contains(text(),'Filter Result')]";
	public static String homePage_WIPISBNcheckboxXpath ="//input[@type='checkbox' and starts-with(@id,'jqg_WIPTitleRecordTable_')]";
	public static String homePage_WIPISBNlinkXpath ="//div[3]/div/table/tbody/tr[2]/td[2]";
	public static String homePage_VendorCreatebuttonXpath ="createRequestBPS";
	public static String homePage_WIPRecordDeletebuttonXpath ="deleteTitleEnabled";
	public static String homePage_WIPRecordDeleteConfirmPopUpXpath ="//Span[.='Confirm']";
	public static String homePage_VendorlistXpath ="span.selectBox-label";
	public static String homePage_VendorNameXpath="Mondal, Tanmay";
	public static String homePage_VendorSaveButtonXpath="saveOnlyBPS";
	public static String homePage_VendorSendRequestXpath="sendRequestButtonBPS";
	public static String homePage_VendorSendRequestContinuePopUpXpath="//span[.='Continue']";
	public static String homePage_VendorNamecheckboxXpath ="//input[@type='checkbox' and starts-with(@id,'jqg_requestTableBPS_')]";
	public static String homePage_VendorNameDeletebuttonXpath ="deleteRequestEnabledBPS";
	public static String homePage_VendorNameDeleteYesPopUpbuttonXpath ="//span[.='Yes']";
	public static String homePage_VendorStatusXpath ="//tr[2]/td[4]";
	public static String homePage_VendorContinueXpath ="btnContinue";
	public static String receivedPublication_XMLarrowXpath ="//a[2]/ins";
	public static String receivedPublication_EditMetaDataXpath ="//a[.='Edit Metadata']";
	public static String receivedPublication_BussinessUnitEditMetaDataPopUpXpath ="contentTypeSelect";
	public static String receivedPublication_SaveEditMetaDataPopUpXpath ="//span[.='Save']";
	public static String receivedPublication_OKEditMetaDataPopUpXpath ="//span[.='OK']";
	public static String receivedPublication_ApproveBookXMLXpath ="Approve Book XML";
	public static String receivedPublication_OKApproveBookXMLPopUpXpath ="//*[contains(text(),'OK')]";
	public static String receivedPublication_ApproveAllChaptersXpath ="Approve All Chapters";
	public static String receivedPublication_AssignXpath ="reassignObookButton";
	public static String receivedPublication_AssignOKXpath ="(//button[@type='button'])[6]";
	public static String receivedPublication_PublishArchiveXpath ="publishAndArchiveOBook";
	public static String receivedPublication_PublishArchivePosttostagingnowXpath ="//*[.='Post to staging now']";
	public static String receivedPublication_PublishArchivePublishonLivenowXpath ="//*[.='Publish on live platform now']";
	public static String homePage_ISBNsearchArchiveXpath = "//*[@id='searchInput']";
	public static String homePage_ISBNArchiveSearchButtonXpath ="//*[@id='searchForm']/input[2]";
	public static String homePage_ViewPublicationXpath = "//*[@id='adminLi']/ul/li[4]/a";
	public static String ViewPublicationISBNXpath = "//*[@id='listAllpublicationsIsbnSearch']";
	public static String ViewPublicationSearchXpath = "//*[@id='listAllpublicationsSearchButton']";
	public static String ViewPublicationDeleteXpath = "//*[@id='deletePublicationEnabled']";
	public static String ViewPublicationDeleteConfirmXpath ="//Span[.='Yes']";
	public static String DeleteMsgXpath = "message";
	public static String ViewPublicationMouseOverXpath = "//*[@id='adminLi']/a";
	public static String ViewPublicationCheckBoxXpath ="//input[@type='checkbox' and starts-with(@id,'jqg_publicationTable')]";
	public static String BPAUserNameXpath ="j_username";
	public static String BPAPasswordXpath ="j_password";
	public static String BPASignInXpath ="//*[@id='signInButton']";
	public static String BPALogOutXpath ="//*[@id='topHeader']/ul/li[3]/a";
	
	// CCH application
	
	public static String CCHuserid="//input[@name='j_username']";
	public static String CCHpasswordid = "//input[@name='j_password']";
	public static String submitCCH_loginid = "//input[@value='> login <']";
	public static String homePage_TransferlogslinkXpath = "Transfer logs";
	public static String Transferlogs_LabelISBNinputXpath = "//input[@name='label']";
	public static String Transferlogs_onPeriodXpath ="//select[@name='period']";
	public static String Transferlogs_SearchbuttonXpath ="//input[@value='Search']";
	public static String Transferlogs_DestinationXpath ="//select[@name='dests']";
	public static String Transferlogs_DestinationmsgXpath="//tr[2]/td[6]";
	
	// DSS Application
	
	public static String LIT_oBookXpath = "(//input[@type='checkbox'])[7]";
	public static String DSSSearchResultXpath = "//div[contains(text(),'NO RESULTS')]";
	public static String DSSViewDetailsXpath = "//a[contains(text(),'View Details')]";
	public static String DSSSafeDeleteXpath = "//button[contains(text(),'Safe Delete')]";
	public static String DSSStatusXpath = "//*[@id='detailsTable']/tbody/tr[13]/td[1]";
	public static String DSSLicenseFilterXpath = "//select";
	public static String DSSLicenseNameXpath = "//input";
	public static String LIT_MRWXpath = "(//input[@type='checkbox'])[5]";
	public static String LIT_MRWQAXpath = "(//input[@type='checkbox'])[6]";
	
	
	
	
//---------------------------------End of BPA Section--------------------------------------------------- 
	
//---------------------------------Start of Literatum Processing Queue Section----------------------------------------------------------------------
	public static String LitGroupXpath ="//*[@id='nav3-issues']/a";
	public static String LitGroupBookXpath="Books";
	public static String LitGroupDOIXpath ="//*[@id='booksTable_doiFilter']";
	public static String loginUserXpath ="login";
	public static String loginPassXpath ="password";
	public static String UniversalDOISearchXpath="//*[@id='txt-universal-doi']";
	public static String DOISearchXpath="//*[@id='btn-universal-doi-search']";
	public static String ClickonActionXpath="//*[@id='bookDetails']/div[1]/div/button";
	public static String ClickonActionMRWXpath="//*[@id='chapterDetails']/div[1]/div/button";
	public static String ClickonActionMoveXpath="//*[@id='bookDetails']/div[1]/div/div/a[4]";
	public static String workflowstateXpath="//*[@id='booksTable_workflowStateFilter']";
	public static String CATRefreshXpath="//*[@id='booksTable_refreshviewbtn']";
	public static String ContentSelectandClickxpath="//td[.='Staging']";
	public static String CATMoveXpath="//*[@id='btn-move-group']";
	public static String CATMoveOkDialogXpath="html/body/div[24]/div[3]/div/button";
	public static String LitProcessingQueueXpath="//*[@id='nav3-processingQueue']/a";
	public static String LitGroupSearchResultXpath="//td[contains(text(),'No data available in table')]";
	public static String LitGroupSearchClickXpath="//*[@id='booksTable']/tbody/tr/td[3]";
	public static String LitGroupDeleteXpath="//a[contains(text(),'Delete')]";
	public static String LitGroupDeletePopupXpath="//*[@id='btn-confirm-delete-group']";
	public static String LitGroupDeletePopupMRWXpath="//*[@id='btn-confirm-delete-item']";
	public static String LitSeriesXpath="//*[@id='nav3-series']/a";
	public static String LitJournalCodeXpath="//*[@id='journalsTable_serialCodeFilter']";
	public static String LitJournalTableXpath="//*[@id='journalsTable_refreshviewbtn']";
	public static String LitClickonJournalCodeXpath="//*[@id='journalsTable']/tbody/tr/td[2]";
	public static String LitIssueInProgressXpath="//label[contains(text(),'Issues In Progress')]";
	public static String LitIssueInProgressSubmitXpath="//button[contains(text(),'Submit')]";
	public static String LitMRWItemDOIXpath ="//*[@id='chaptersTable_doiFilter']";
	public static String CATRefreshMRWXpath="//*[@id='chaptersTable_refreshviewbtn']";
	public static String LitGroupSearchMRWClickXpath="//*[@id='chaptersTable']/tbody/tr/td[3]";
	
	
	
//---------------------------------End of Literatum Processing Queue Section----------------------------------------------------------------------
		
	
	
	// Home Page 
	public String wileyOnlineLibaryImageXpath = "//*[@id='header']/div[2]/div/h1/a/img";
	
	
	// Search Item 
	
	public String searchTextXpath = "searchText";
	public String allcontentXpath = "searchAllContent";
	public String searchButtonXpath = "searchSiteSubmit";
	public String searchResultPageXpath = "//*[@id='searchResults']/div[1]/h1";
	public String publicationLinkXpath = "//*[@id='globalMenu']/div/ul/li[1]/a";
	
	//Search Result Page
	public String journalFilterListXpath = "//*[@id='pubtype-facet']/li[1]/a";
	public String booksFilterListXpath = "//*[@id='pubtype-facet']/li[2]/a";
	public String referenceWorkFilterListXpath = "//*[@id='pubtype-facet']/li[3]/a";
	public String bookSeriesFilterListXpath = "//*[@id='pubtype-facet']/li[4]/a";
	public String databaseFilterListXpath = "//*[@id='pubtype-facet']/li[5]/a";
	public String labprotocolFilterListXpath ="//*[@id='pubtype-facet']/li[6]/a";
	public String reomvoeFilterXpath = "//*[@id='pubtype-facet']/li[7]/a";
	public String refworkFilterListNoLinkXpath = "//*[@id='pubtype-facet']/li[3]";
	
	
	public String view120Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[1]/a";
	public String view2140Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[2]/a";
	public String view4160Xpath = "//*[@id='searchResultsList']/div[1]/ol/li[3]/a";
	public String view6180Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[4]/a";
	public String viewnextXpath =  "//*[@id='searchResultsList']/div[1]/ol/li[5]/a";
	public String viewprevXpath =  "//*[@id='searchResultsList']/div[1]/ol/li[1]/a";
	
	
	public String noresultfoundXpath = "//*[@id='searchResultsList']/p";
	public String ContentvalueXpath = "//*[@id='searchedForText']/em[1]";
	public String ContenttypeXpath = "//*[@id='searchedForText']/em[2]";

	//Publicatin A-Z		
	public String journalFilterLista2zXpath = "//*[@id='filterLists']/ul/li[1]/a";
	public String booksFilterLista2zXpath = "//*[@id='filterLists']/ul/li[2]/a";
	public String refworkFilterLista2zXpath = "//*[@id='filterLists']/ul/li[3]/a";
	public String bookSeriesFilterLista2zXpath = "//*[@id='filterLists']/ul/li[4]/a";
	public String databaseFilterLista2zXpath = "//*[@id='filterLists']/ul/li[5]/a";
	public String labprotocolFilterLista2zXpath ="//*[@id='filterLists']/ul/li[6]/a";
	public String reomvoeFiltera2zXpath = "//*[@id='filterLists']/ul/li[7]/a";
	
	
	
	//Login Page
	
	public static String UserName_xpath = "//input[@id='login']";
	public static String Password_xpath = "//*[@id='password']";
	//public String Remember_me_xpath = "//*[@id='login']/div/form/p[3]/input";
	public static String Login_xpath = "//input[@value='Log In']";
	//public static String Login_xpath = "//*[starts-with(@class,"button btn submit primary no-margin-bottom")]";
	public String loginoverlay_xpath = "//*[@id='header']/div[2]/div/div[1]/a/i";
	public static String loginchecker_xpath = "//a/span[2]";
	public String logout_xpath = "//*[@id='loggedIn']//a[contains(text(), 'Log Out')]";
	public static String UserName_xpath1 = "//input[@id='login']";

	//Journal Page
	
	public static String JournalToolsxpath = "//*[@id='pageNavAndTools']/div[1]/h2";
	public static String AALinkxpath = "//*[@id='acceptedArticlesLink']";
	public static String RequestPermissionLinkxpath = "//*[@id='promosAndTools']//a[.='Request Permissions']";
	public static String requestpermissionSearchresultxpath = "//*[@id='searchResultsList']/ol//a[.='Request Permissions']";
	public static String myprofilelinkxpath = "//*[@id='indivLogin']/span[2]";
	public static String myprofilelinkcheckxpath = "//a[contains(text(),'My account')]";
	public static String savedarticlesxpath = "//*[@id='savedItemsAndAlerts']//a[contains(text(), 'Saved Articles')]";
	public static String selectAllCheckBoxxpath = "//*[@id='selectAllTop']";
	public static String deletearticlebtnxpath = "//*[@id='savedArticlesList']/div[1]/ul/li/input";
	public static String selectcheckboxsearchresultxpath = "//*[@id='option1']";
	public static String savetoprofilebtnxpath = "//*[@id='searchResults']/form/div[1]/ul[1]/li[1]/input";
	public static String requestpermissioninmyprofilexpath = "//*[@id='savedArticlesList']/ol/li//a[.='Request Permissions']";
	public static String checkmyaccountxpath = "//*[@class=' col-sm-6 gutterless ']";
	public static String savetomyprofilexpath = "//*[@id='folder']";
	public static String savedpublicationsxpath = "//*[@id='savedItemsAndAlerts']//a[contains(text(), 'Saved Publications')]";
	public static String referenceworkinmyprofilexpath = "//*[@id='publications']//span[contains(text(), 'REFERENCE WORK')]";
	public static String deletepublicationbtnxpath = "//*[@id='savedPublicationsList']/div[1]/ul/li/input";
	public static String subscriptionaccesslinkxpath = "//a[contains(text(), 'Subscription Access')]";
	public static String subscriptionaccesscustidxpath = "//*[@id='customerId']";
	public static String subscriptionaccessaccesscodexpath = "//*[@id='accessCode']";
	public static String subscriptionsubmitxpath = "//*[@id='subscriptionAccess']/form/input";
	public static String clickupdatexpath= "//input[@value='UPDATE']";
	
	//Integration Check for Password Policy
	public static String clickAS2Checkid="checkboxLoginTermsFlag";
	public static String clickNextxpath="(//button[@type='button'])[2]";
	public static String clickMyProfile_xpath="(//a[contains(text(),'My Profile')])[2]";

	public static String as2LoginLinkbtn_xpath="//a[@class='menu__btn menu__btn_active action-anchor-menu-login-button']";
	public static String as2loginEmailid="login-inputEmail";
	public static String as2loginPWDid="login-inputPassword";
	public static String as2Loginbtnid="login-btn";
	public static String as2Myprofilelocator_xpath="//*[@class='page__nav-bar']//li[2]/a";
	public static String customerdropdwnid="pt1:_d_reg:region1:1:r2:0:dtrt_dc_4061095816::content";
	public static String userStatusdropdownid="pt1:_d_reg:region1:1:r2:0:dtrt_dc_9433075672::content";
	public static String loginErrMsg_xpath="//*[@id='pb-page-content']/div/div[4]/div/div[2]/div[2]/div[1]";
	public static String as2AreaOfInterest_xpath="//*[@id='content']/div/div[1]/div/div/div/div[1]/div[3]/div/div[3]/div/div[1]/input";
	public static String as2AreaOfInterestlist_xpath="//*[@id='content']/div/div[1]/div/div/div/div[1]/div[3]/div/div[3]/div/div[2]/ul/li[2]";
	
	//literatumhomepage
	public static String homepagemovexpath = "//img[@alt='Wiley Online Library']";
	public static String checkFeaturedxpath = "//*[@class='pageBody']//section[3]//h4";
	
	//public static String checkImagesrcxpath = "//*[@id='pb-page-content']/div/div[7]/div/div/section[3]/div/div/div/div[2]/div[1]/div/div/div[1]/img";
	public static String checkImagesrcxpath = "//*[@class='pageBody']//section[3]//img";
	//public static String browseBysubjectxpath = "//*[@id='pb-page-content']/div/div[7]/div/div/section[1]/div/section/div/div/div/section/h2/span";
	public static String browseBysubjectxpath = "//*[@class='pageBody']//section[2]//h4";
	public static String checksubjectlistxpath = "//*[@class='accordion']/ul/li[1]/a";
	public static String searchvaluexpath = "//*[@id='searchField1']";
	public static String searchsubmitxpath = "//*[@ class='main-search-field-wrapper']/form/button";
	public static String checkthevaluexpath = "//*[@class='search__result search__result--space']/span[3]";
	public static String countthevaluexpath = "//*[@class='search__result search__result--space']/span[1]";
											   //*[@id='pb-page-content']/div/div[6]/div/div/div/div/div/div/div[2]/div/div/div[1]/div[1]/div[1]/span[1]
	
	public static String clickPublicationxpath= "(//a[@id='facetList-0']/span)[193]";
	public static String clickIcurContentxpath= "//*[@id='filter']/div[4]/div/ul/li/ul/li/a/span[1]";
	public static String journalnamexpath = "//*[@id='atl']/h2/span/i";
	// Literatum Jounral Homepage
	public static String clickJournalxpath = "//*[@class='homepage-search-headings']/div/div/div/div[1]/a";
	public static String checkJournalxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/div[1]/span[1]";
	public static String clickJournalTitlexpath = "//*[@class='search-result showPublications']/ul/li[1]/div/h3/a";
	public static String issueFirstPublishDatexpath = "//*[@id='pb-page-content']/div/div[8]/div/div/div[1]/section/div/div/div[2]/ul/li/div[2]/div/span";
	public static String homepagemovejournalxpath = "//img[@alt='Wiley Online Library']";
	public static String checkmetadaISSNxpath = "//*[@class='journal-info-container col-md-8']/div[2]/div";
	public static String checksubjectxpath = "//*[@id='filter']/div[3]/a/h4";
	public static String searchtextboxid = "searchField0";
	public static String searchtextboxid1 = "searchField1";
	public static String SearchDropDownValueclassName = "dropBlock";
	public static String autosuggestionboxid = "ui-id-1";
	public static String autosuggestionboxelementxpath = "//*[@id='ui-id-1']//span";
	public static String clickvolumeissuexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e11con']";
	public static String checkvolumeissuexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e11']/ul/li[1]/div[2]/h4/a";
	public static String advSearchLinkclassName = "advanced-search-link";
	public static String advSearchTextBox1xpath = "text2";
	public static String advsearchsearchoptionid = "searchArea2";
	public static String submitButtonclass = "//button[contains(text(), 'Search')]";
	public static String submitButtonhome = "btn quick-search__button icon-search";
	public static String selectclickclass = "jcf-select-text";
	public static String advSearchLinkheaderText = "Advanced Search";
	public static String citationSearchLinkheaderText = "Citation Search";
	public static String citationSearchTextBox1name = "quickLinkJournal";
	public static String citationYearTextBoxname = "quickLinkYear";
	public static String citationVolumeTextBoxname = "quickLinkVolume";
	public static String citationIssueTextBoxname = "quickLinkIssue";
	public static String CitationSearchPageValuesclassName = "cover-image__details";
	public static String submitButtonCitationclass = "//button[.='SEARCH']";
	public static String SaveSearchOptionid = "saveSearchTriggerButton";
	public static String SaveSearchPopupid = "saveSearchDialog";
	public static String SaveSearchLoginOptionXpath = "//a[contains(text(), 'login')]";
	public static String searchItemClass = "//*[@class='clearfix separator search__item']";
	public static String pdfLinkText = "PDF";
	
	public static String clickissuerangexpath= "//*[@id='47d7f162-6ab4-45a3-8f7c-7a3f66e0068e']/div/ul/li[9]/div/a/span";
	public static String checkissueyearxpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e02con']/span";
	public static String clcikbrowsearticlexpath= "(//a[@id='main-menu-1-3']/span)[2]";
	//public static String clickAllIssuescss= "#menubar > #menu-item-3 > ul.rlist.dropdown__menu > li.menu-item > a[title='All Issues']";
	public static String clickAllIssuescss= "a[title='All Issues']";
	public static String clickAllIssuesxpath= "(//li[@id='menu-item-main-menu-1-3']/ul/li[4]/a/span)[2]";
	public static String clickVolumexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e01']/ul/li[1]/div[2]/h4[1]/a";
	public static String scrollPagexpath= "//*[@class='cover-image__parent-item']";
	public static String clickFullTextxpath= "//*[@class='card card--light-shadow issue-items-container']/div/div[2]/ul/li[2]/a";
	
	 public static String checkHomeTabid= "a[title='Home'] > span";
	    public static String checkAboutTabid= "#menubar > #menu-item-main-menu-1-1 > #main-menu-1-1 > span";
	    public static String checkTOCTabid= "//li[3]/a/span";
	    public static String checkBBTTabid= "//li[4]/a/span";
	    public static String checkBAZTabid= "//li[5]/a/span";
	    public static String checkShareTabid= "i.icon-Icon_Share";
	    public static String checkShareTabvalueid= "//*[@id='share_Pop']/p";
	    public static String clickBookxpath = "//*[@class='homepage-search-headings']/ul/li[2]/a";
		public static String checkBookxpath = "//*[@class='search-result showPublications']";  
	
	//Literatum Article Page
	public static String clickAbstractxpath = "//*[@id='pane-01cbe741-499a-4611-874e-1061f1f4679e01']/div/div[2]/div[2]/ul/li[1]/a";
	//public static String clickAbstractxpath = "(//a[contains(text(),'Abstract')])[4]";
	public static String checkAbstractxpath = "//*[@id='section-1-n/a']/h3";
	public static String checkTheAuthorxpath1 = "//*[@id='a1_Ctrl']/span";
	public static String checkTheAuthorxpath2 = "//*[@id='a2_Ctrl']/span";
	public static String clickBeforeAbstractxpath = "//*[@id='pane-01cbe741-499a-4611-874e-1061f1f4679e01']/div/div[1]/a/h3/b";
	public static String checkMultilingualid = "//*[@id='section-1-en']/a";
	public static String BookHomeTOCtextXpath = "//*[@class= 'gutterless--xs gutterless--sm gutterless--md main-content col-md-8']";
	public static String JournalArticleLinkxpath = "//a[.='Full text']";
	public static String clickonArticleLinkclass = "//*[@class= 'journal-tabs card card--light-shadow']";
	public static String clickonArticleLinkclass1 = "//*[@class= 'publication-list__item' or @class= 'issue-item']";
	
	//Literatum Book Chapter
	public static String clickBooktxpath = "//*[@class='homepage-search-headings']/div/div/div/div[3]/a";
	public static String checkBooktxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/div[1]/span[1]";
	public static String clickonABookxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/h3/a";
	public static String checkmetadaISBNxpath = "//*[@class='journal-info-container col-md-8']/div[2]/div[3]/span[6]";
	public static String clickonAchapterxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[3]/div[2]/div/a/h5";
	public static String tableofcontentxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[2]/h4";
	public static String checkchaptersectionxpath = "//*[@class='article-citation']/div/h2";
	
	
	//Literatum about this book
	
	public static String checkcontentclass = "aboutBook";
	public static String checkshowid= "read-more";
	public static String checkshowallcontentsectionxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[1]/div/ul/li[1]";
	
	//Readcube 
	
	public static String ShareLinkArticleId = "share__ctrl";
	public static String ReadcubeSharingXpath = "//*[@class='readCube-sharing']/a";
	
	//Literatum book search box
	public static String clicksearchboxid= "searchField0";
	public static String clicksearchdropdownclass = "dropBlock";
	public static String clicksearchvalueid= "pane-67065c09-4a88-49cd-934c-ac707951d35c1-con";
	public static String checksearchboxxpath = "//div[@classname= 'dropBlock']/a/span";
	public static String searchsubmitbuttonxpath ="(//button[@type='submit'])[2]";
	public static String clickoutsidexpath= "page-header";
	
	//public static String clicksearchnewboxcss= "div.input-group.option-1 > #searchField";
	public static String clicksearchnewboxcss= "searchField1";
	// Cochrane
	
	public static String SearchTermFieldxpath = "//*[@id='search_query']";
	
	/*-----------------------------------------------------------------------------*/
	// Home Page
	public String Logout_xpath = "//*[@class='user-controls']/a/div";
	public String countoflink_xpath = "//*[@id='navTree']/div[2]/ul/li";
	public String testlevelxpath = "//*[@class='edit_area']/h3/a[1]";
	public String subtestlevelxpath = "//*[@class='edit_area']/h3/a[2]";
	public String itemLevelxpath = "//*[@class='content-tool-right-content']/div/div/h3/a[4]";
	public String itemGroupxpath = "//*[@class='edit_area']/h3/a[3]";
	public String itemxpath1 ="//*[@class='edit_area']/h3/a[4]";
	public String itemxpath2 = "//*[@class='edit_area trial_edit_page']/h3/a[4]";
	public String trialxpath = "//*[@class='edit_area trial_edit_page']/h3/a[5]";
	
	
	//DSS
	public static String DSSUserName = "j_username";
	public static String DSSPasswordName = "j_password";
	
	public static String button_login_class = "loginButton";
	public static String SearchBox_class = "//*[@class='panel-body']/table//tr//input";
	public static String SearchBtn_xpath = "//*[@value='Search']";
	public static String LogoutLink = "LOGOUT";
	public static String TitleTextXpath = "//*[@class='container-fluid']/table//tr/td[2]";
	public static String textAreaValueTag = "textarea";
	public static String Check_content_items_xpath = "//*[@value='Check content items']";
	public static String select_option_Tag = "select";
	public static String Ignore_validation_ID = "//ul[@class='list-group']/li/div";
	public static String Use_license_priority_ID = "(//ul[@class='list-group'])[2]/li/div";
	public static String Start_immediately_ID = "(//ul[@class='list-group'])[3]/li/div";
	public static String Literatum_Issue_Test_xpath = "(//input[@type='checkbox'])[8]";
	public static String Deliver_btn_id = "deliverBtn";
	public static String checkrownumber_xpath = "//*[@id='striped']/tbody/tr";
	
	//Login UAT TO WIP
	public static String userDetails_id="username";
	public static String passwordDetails_id="password";
	public static String loginDetails_id="login";
	
	//Compare WIP & UAT
	
	public static String clickOnSelection_xpath=".//*[@id='journalNav']/li[2]/a";
	public static String clickOnEntries_xpath=".//*[@id='myTable_length']/label/select";
	public static String clickOnSearch_xpath=".//*[@id='myTable_filter']/label/input";
	
	//
	public static String selectionTabXpath = ".//*[@id='journalNav']/li[2]/a";
	public static String numberJournalXpath = ".//*[@id='myTable_length']/label/select";
	public static String searchFieldXpath = ".//*[@id='myTable_filter']/label/input";
	public static String viewXpath = ".//*[@id='myTable']/tbody/tr/td[1]/a";
	public static String journalTitleId = "journalTitle";
	public static String journalIssnId = "journalISSN";
	public static String journalTypeId = "journalType";
	public static String institutionalOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[3]/td[1]/input";
	public static String institutionalPrintOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[4]/td[1]/input";
	public static String institutionalPrintXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[5]/td[1]/input";
	public static String amountAmericasOnlineOnlyXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[3]/td[3]";
	public static String amountUKOnlineOnlyXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[3]/td[4]";
	public static String amountEuropeOnlineOnlyXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[3]/td[5]";
	public static String amountROWOnlineOnlyXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[3]/td[6]";
	public static String sapIssnId = "btnSAPIssntblcurrentPrices";
	public static String RelationshipIDid="btnRelCattblcurrentPrices";
	public static String amountAmericasPrintOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[4]/td[3]";
	public static String amountUKPrintOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[4]/td[4]";
	public static String amountEuropeOnlinePrintOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[4]/td[5]";
	public static String amountROWOnlinePrintOnlineXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[4]/td[6]";
	public static String amountAmericasPrintXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[5]/td[3]";
	public static String amountUKPrintXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[5]/td[4]";
	public static String amountEuropePrintXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[5]/td[5]";
	public static String amountROWPrintXpath = ".//*[@id='tblcurrentPrices']/tbody/tr[5]/td[6]";
	public static String tablePricingDetailId = "tblcurrentPrices";
	public static String environMentDetailId = "brandName";
	
	
	
	//ALM TO LIT
	
	public static String ALMUserEmailField_xpath=".//*[@id='pt1:_d_reg:region0:1:qryId1:value20::content']";
	public static String ALMSearchUser_xpath=".//*[@id='pt1:_d_reg:region0:1:qryId1::search']";
	public static String ALMClickSearchedUser_xpath=".//*[@id='pt1:_d_reg:region0:1:pc1:resId1:0:cl1']";
	public static String ALMuserid="pt1:_pt_it1::content";
	public static String ALMPasswordid = "pt1:_pt_it2::content";
	public static String submitALM_loginid = "pt1:_pt_cb1";
	public static String cust_id= "pt1:_d_reg:region1:1:r2:0:dtrt_dc_5618271006::content";
	public static String login_id="pt1:_d_reg:region1:1:r2:0:_xg_42::content";
	public static String insPasswordid="pt1:_d_reg:region1:1:r2:0:_xg_48::content";
	public static String confirminspasswordid="pt1:_d_reg:region1:1:r2:0:_xg_148::content";
	public static String senddateid="pt1:_d_reg:region1:1:r2:0:dtrt_dc_8217010174::content";
	public static String sendmoddateid="pt1:_d_reg:region2:1:r2:0:dtrt_dc_3785338307::content";
	public static String descriptionrem_xpath="//*[@class='v-formlayout-row'][2]//input";
	public static String custname_id= "pt1:_d_reg:region1:1:r2:0:_xg_9::content";
	public static String maxuser_id="pt1:_d_reg:region1:1:r2:0:dtrt_dc_1845986669::content";
	public static String access_id= "pt1:_d_reg:region1:1:r2:0:dtrt_dc_3914573057::content";
	public static String societyURL_id= "pt1:_d_reg:region1:1:r2:0:dtrt_dc_9029422160::content";
	//public static String submitcustomerxpath= "//*[@id='pt1:_d_reg:region1:1:commandToolbarButton2']/a/span";
	public static String submitcustomerxpath= "//*[contains(text(), 'Submit')]";
	public static String adminPasswordid="pt1:_d_reg:region1:1:r2:0:_xg_48::content";
	public static String adminConPasswordid="pt1:_d_reg:region1:1:r2:0:_xg_148::content";
	public static String clickradio_id="//*[@name='RadioButtons'][1]";
	public static String setpassword_id="//*[@type='password']";
	public static String resetpassword_id="//*[contains(text(), 'Confirm New Password')]/../../../tr[2]//input";
	public static String clickresetpassword_id="//button[contains(text(), 'Reset Password')]";
	public static String custValuexapth="//*[@id='pt1:_d_reg:region1:2:pgl4']/tbody/tr/td[3]/span";
	public static String stateValuexpath="//*[@id='pt1:ptsi1']/img";
	public static String LITuserid="login";
	public static String LITpasswordid="password";
	public static String submitLIT_loginname="submit";
	public static String adminxpath="//span[contains(text(), 'Administration')]";
	public static String contentslice_xpath="//*[.='Content Slices / Bundles']";
	public static String License_xpath="//*[.='Licenses']";
	public static String Addressxpath="//*[contains(text(), 'Addresses')]";
	//public static String Addressxpath="//*[.='Addresses']";
	public static String accesstokenxpath="//*[contains(text(), 'Access Tokens')]";
	public static String tokenvalxapth="//*[@class='v-formlayout-contentcell']//input";
	public static String searchtokenxpath="//*[@class='v-horizontallayout v-layout v-horizontal v-widget form-operations v-horizontallayout-form-operations']/div/div/div";
	public static String identixpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[3]/div/div/div[3]/div/div[1]/div/span/span[2]";
	public static String publicvalid="//*[@class='v-formlayout-row v-formlayout-firstrow']//input";
	public static String publicIP_xpath="//*[@class='v-formlayout-row v-formlayout-lastrow']//input";
	public static String codeval_xpath="//*[@class='v-formlayout-row']/td[3]/input";
	public static String prodcodeval_xpath="//*[@class='v-formlayout-row v-formlayout-lastrow']/td[3]/input";
	public static String searchLicense_xpath="//*[@class='v-horizontallayout v-layout v-horizontal v-widget form-operations v-horizontallayout-form-operations']/div/div/div";
	public static String searchxpath="//*[@class='v-button v-widget primary v-button-primary']";
	public static String fetchDescxpath="//input[contains(@id, 'gwt-uid')][2]";
	public static String emailuser_id="pt1:_d_reg:region1:1:r2:0:_xg_42::content";
	public static String passworduser_id="pt1:_d_reg:region1:1:r2:0:_xg_48::content";
	public static String confirmpassworduser_id="//*[contains(text(), 'Confirm Password')]/../..//td[2]/input";
	public static String clickonImitate_xpath="//*[@class='v-horizontallayout v-layout v-horizontal v-widget form-operations v-horizontallayout-form-operations']/div[7]/div/div";
	public static String clickspace_xpath="//*[@class='v-widget v-has-caption v-caption-on-top']//input";
	public static String checkOKContent_xpath="//*[@class='v-slot v-slot-a-centered-btn']/div/div/div";
	public static String clickinsspace_xpath="//*[@class='v-window-contents']//input";
	
	//Instituotional address update in LIT
	public static String clickonAddress_xpath="//*[@class='v-scrollable v-table-body-wrapper v-table-body']/div";
	public static String address1xpath="//*[@class='v-formlayout-row'][3]//input";
	public static String cityxpath="//*[@class='v-formlayout-row'][5]//input";
	public static String statexpath="//*[@class='v-formlayout-row'][6]//input";
	public static String zipcodexpath="//*[@class='v-formlayout-row'][7]//input";
	public static String phonexpath="//*[@class='v-formlayout-row'][9]//input";
	
	//add affiliation society
	public static String addaffiliationxpath="//*[@class='v-customcomponent v-widget v-has-width']/div";
	public static String addisvisiblexpath="//*[@class='v-customcomponent v-widget v-has-width']/div/span/span";
	public static String clickonline_xpath="//*[@class='v-slot v-slot-a-full-width v-slot-a-root-component']//table[@class='v-table-table']//tr";
	public static String clickonline1_xpath="//*[@class='v-scrollable v-table-body-wrapper v-table-body']//table[@class='v-table-table']//tr";
	public static String addafftosocxpath="//*[@class='v-slot v-slot-sub-window-bottom-buttons']/div/div[2]";
	
	public static String removedata_xpath="//*[@class='v-slot v-slot-form-operations']/div/div[3]";
	
	// License PAge
	public static String LicenseID_id="pt1:_d_reg:region3:1:it3::content";
	public static String description_id="pt1:_d_reg:region3:1:it6::content";
	public static String description1_id="pt1:_d_reg:region4:1:it1::content";
	public static String tokens_id="pt1:_d_reg:region3:1:it8::content";
	public static String contentStartDate_id="pt1:_d_reg:region3:1:id1::glyph";
	public static String startdate="//*[@class='xmj p_AFSelected']";
	public static String contentEndDate_id="pt1:_d_reg:region3:1:id3::glyph";
	public static String enddate="//*[@id='pt1:_d_reg:region3:1:id3::pop::cd::cg']/tbody/tr[6]/td[2]";
	public static String enddate1="//*[@id='pt1:_d_reg:region3:1:id4::pop::cd::cg']/tbody/tr[6]/td[2]";
	public static String selectarrow_id="pt1:_d_reg:region3:1:id3::pop::cd::nm";
	public static String validFromDate_id="pt1:_d_reg:region3:1:id2::glyph";
	public static String validEndDate_id="pt1:_d_reg:region3:1:id4::glyph";
	public static String selectarrow1_id="pt1:_d_reg:region3:1:id4::pop::cd::nm";
	public static String addProduct_xpath="//*[.='Add Product']";
	public static String productID_id="pt1:_d_reg:region3:1:qryId1:value00::content";
	public static String search_id="pt1:_d_reg:region3:1:qryId1::search";
	public static String newrow_xpath="//*[@id='pt1:_d_reg:region3:1:pc2:resId1::db']/table/tbody/tr/td[1]";
	public static String addSelected_xpath="//*[.='Add Selected']";
	public static String selectok_id="pt1:_d_reg:region3:1:cb2";
	public static String submitLicense_id="pt1:_d_reg:region3:1:cb1";
	public static String modifyLicense_xpath="//*[contains(text(), 'Modify License')]";
	public static String tranID_id="pt1:_d_reg:region3:1:it4::content";
	public static String fullID_id="pt1:_d_reg:region3:1:it5::content";
	public static String deletelicense_xpath="//*[contains(text(), 'Delete License')]";
	public static String deleteok_id="pt1:_d_reg:region2:1:d1::ok";
	public static String LicenseID_id_search_id = "pt1:_d_reg:region0:1:qryId1:value00::content";
	public static String searchLicenseButton_xpath = "//button[.='Search']";
	//public static String LicenseID_token_count_xpath = "//table[@class='xzz x10q']//td[9]";
	//public static String LicenseID_token_count_xpath = "//div[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr/td[9]/span";
	public static String LicenseID_token_count_xpath = "//div[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr/td[9]";
	
	
	public static String InstituteLoginxpath = "//*[@class='login-bar-container']//a";

	public static String InstitutionalAdminxpath = "//*[@class='navigation-login-dropdown']//a[.='Institutional administration']";

	//public static String InstitutionalAdminxpath = "//*[@class='navigation-login-dropdown']//a[.='";
	//public static String InstitutionalAdminxpath = "//*[@class='navigation-login-dropdown']//a[.='Institutional administration']";
	


	//public static String ArticleSelectxpath = "//*[@class='profile-menu']//a[.='Article select']";
	public static String ArticleSelectxpath = "//*[@class='profile-menu']/ul[2]/li[6]";
	public static String IPRanges_xpath="//*[@class='profile-menu']/ul[2]/li[4]";
	public static String addDescription_xpath="//*[@id='institutionMultiIpAdd']/div[1]/div[2]/input";
	public static String LicenseID_Lit_xpath = "//table[@class='expandable']//tr[1]/td[1]";
	public static String Token_Lit_xpath = "//table[@class='expandable']//tr[1]/td[5]";

	public static String permissions_xpath="//*[contains(text(), 'PERMISSIONS')]";
	public static String Addper_xpath="//*[@class='manage-article-select']/div[1]/form/input";
	public static String Addemail_xpath="//*[@class='manage-article-select']//input";
	public static String AddIP_xpath="//*[@id='institutionMultiIpAdd']/div[2]/div[2]/input";
	public static String AddIPrange_xpath="//*[@id='institutionMultiIpAdd']/div[3]/input";

	
	public static String licensexpath="//*[.='Licenses']";
	
	public static String sendIP_xpath = "//tr[@class='v-formlayout-row'][2]/td[3]/input";
	
	public static String descriptionIP_xpath="//*[@class='v-formlayout-row']//input";
	//public static String clickonpdf_xpath="(//a[contains(text(),'PDF')])[4]";
	public static String clickonpdf_xpath="(//a[contains(text(),'PDF')])[2]";
	public static String clickonchapter_xpath="(//a[contains(text(),'CHAPTER PDF')])[2]";

	public static String clickondownload_xpath= "//span[contains(text(),'DOWNLOAD FULL BOOK')]";
	public static String aboutthisbook_xpath="//*[contains(text(), 'About this book')]";

	public static String downloadfullbook_xpath = "//*[@id='pb-page-content']/div/div[2]/div/div/section/div/div/div/div[1]/div/div[2]/ul/li[2]/a/span";

	public static String minIP_xpath="//*[@class='v-formlayout-row'][2]//input";
	public static String maxIP_xpath="//*[@class='v-formlayout-row v-formlayout-lastrow']//input";
	public static String sendLID_xpath="//*[@class='v-formlayout-row'][1]//input";
	public static String create_xpath="//*[@class='primary v-widget']";
	
	//Product Page
	public static String createProductID_id="pt1:_d_reg:region1:1:itt3::content";
	public static String productDescID_id="pt1:_d_reg:region1:1:itt2::content";
	public static String searchProd_id="pt1:_d_reg:region0:1:qryId1:value10::content";
	public static String clickonprodid_id="pt1:_d_reg:region0:1:pc1:resId1:0:cl1";
	public static String modifyproduct_xpath="//*[contains(text(), 'Modify Product')]";
	public static String modProdDesc_id="pt1:_d_reg:region2:1:it1::content";
	public static String addContent_xpath="//*[contains(text(), 'Add Content')]";
	public static String removeContent_xpath="//*[contains(text(), 'Remove Content')]";
	public static String electronicdet_id="pt1:_d_reg:region2:1:qryId1:value10::content";
	public static String contentsearch_id="pt1:_d_reg:region2:1:qryId1::search";
	public static String selcontentrow_xpath="//*[@id='pt1:_d_reg:region2:1:pc2:resId1::db']/table/tbody/tr/td[1]";
	public static String addSelectRow_xpath="//*[@id='pt1:_d_reg:region2:1:pc2:commandToolbarButton2']/a/span";
	public static String addOkContent_xpath="pt1:_d_reg:region2:1:cb3";
	public static String deleteOKContent_xpath="//*[contains(text(), 'OK')]";
	public static String deleteproduct_xpath="//*[contains(text(), 'Delete Product')]";
	public static String deleteOKProduct_id="pt1:_d_reg:region0:1:d1::ok";
	
	//IP Auth
	public static String clickonAuth_xpath="//*[contains(text(), 'Authentication Methods')]";
	public static String clickonIP_xpath="//*[contains(text(), 'IP Address')]";
	public static String clickonReg_xpath="//*[contains(text(), 'Regional Province')]";
	public static String clickonModify_xpath="//td[3]/div/a/span";
	public static String addIP_id="pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgctb_0::icon";
	public static String deleteIP_id="pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgctb_1::icon";
	public static String clickonEnterIP_xpath="//*[@id='pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgtb_0::db']/table/tbody/tr/td[1]";
	public static String enterIP_id="pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgtb_0:1:_xgc_7::content";
	public static String readyToSubmit_xpath="//*[@id='pt1:_d_reg:region2:1:r2:0:cb2']/a/span";
	
	//subscription affiliation
	public static String profilename_xpath="//*[@id='indivLogin']/span[2]";
	public static String onAccount_xpath="//a[contains(text(),'My account')]";
	public static String subcriptionacc_xpath="//li[4]/a/span";
	public static String customerID_id="tokenAccess";
	public static String accessID_id="tokenKey";
	public static String accessSubmit_xpath="//*[@id='accessTokenForm']/div[3]/input";
	
	
	//Reg
	public static String clickMemberxpath="//*[contains(text(),'Members')]";
	
	//Add Affiliation
	public static String clickonView_xpath="//*[contains(text(),'View Details')]";
	public static String clickonModUser_xpath="//*[contains(text(),'Click Here to Modify the Details')]";
	public static String addEmailid="pt1:_d_reg:region3:1:r2:0:_xgc_2:_xgctb_0::icon";
	public static String clickonEnterEmail_xpath="//*[@id='pt1:_d_reg:region3:1:r2:0:_xgc_2:_xgtb_0::db']/table/tbody/tr/td[1]";
	public static String enterEmailid="pt1:_d_reg:region3:1:r2:0:_xgc_2:_xgtb_0:1:_xgc_7::content";
	public static String sendEmail_xpath="//*[@class='v-formlayout-row'][2]//input";
	public static String setverify_xpath="//*[@class='v-formlayout-row v-formlayout-lastrow']//span[2]/input";
	public static String readyToSubmitemailxpath="//*[@id='pt1:_d_reg:region3:1:r2:0:cb2']/a/span";
	public static String deleteEmailid="pt1:_d_reg:region3:1:r2:0:_xgc_2:_xgctb_1::icon";
	
	//Add Personal User
//	public static String sendpassword_xpath="//*[@class='v-formlayout-row'][5]//input";
//	public static String sendfirst_xpath="//*[@class='v-formlayout-row'][6]//input";
//	public static String sendlast_xpath="//*[@class='v-formlayout-row'][7]//input";
	public static String sendpassword_xpath="(//*[@class='v-formlayout-row'][1]//input)[2]";
	public static String sendfirst_xpath="(//*[@class='v-formlayout-row'][2]//input)[2]";
	public static String sendlast_xpath="//*[@class='v-formlayout-row'][3]//input";
	public static String clickonCreate_xpath="//*[@class='v-horizontallayout v-layout v-horizontal v-widget form-operations v-horizontallayout-form-operations']/div[3]/div";
	public static String sendEmailcreated_id="pt1:_d_reg:region0:1:qryId1:value20::content";
	public static String clickonEmail_id="pt1:_d_reg:region0:1:pc1:resId1:0:cl1";
	public static String clickonEmail_xpath="//div[2]/table/tbody/tr/td[3]/a";
	public static String emailValue_xpath="//*[@id='pt1:_d_reg:region1:1:pgl4']/tbody/tr/td[3]/span";
	public static String clickonUpdate_xpath="//*[@class='v-slot v-slot-form-operations']/div/div/div";
	public static String clickonYes_xpath="//*[@class='v-slot v-align-center v-align-middle']/div/div";
	public static String sendfirstupdate_xpath="//*[@class='v-formlayout-row'][2]//input";
	public static String updatePassword_xpath="//*[contains(text(),'Password')]/../../../td[3]/input";
	
	//Add address
	public static String clickonUser_xpath= "//a[@id='indivLogin']/span[2]";
	public static String updateDetails_xpath="//*[@id='personalInformationForm']/div[2]/input";
	public static String addDetail1_id="address.address1";
	public static String addCity_id="address.city";
	public static String SubmitAddress_name="submit";
	
	
	
	// Modify Cusotmer ALM
	public static String customeID_id="pt1:_d_reg:region0:1:qryId1:value20::content";
	public static String clickonsearch_xpath="pt1:_d_reg:region0:1:qryId1::search";
	public static String clickoncustid_xpath="//div[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr/td[2]/span/a";
	public static String clickoncustid_id="pt1:_d_reg:region0:1:pc1:resId1:0:ot9";
	public static String clickonAttribute_xpath="//*[.='Attributes']";
	public static String clickmanageLicnese_xpath="//*[.='Manage Licenses']";
	public static String clickAddLicense_xpath="//*[.='Add License']";
	public static String clickmodify_xpath= "//*[.='Modify Customer']";
	public static String clickreset_xpath="//*[.='Reset Password']";
	public static String clickdelete_xpath="//*[.='Delete Customer']";
	public static String firstName_id="//*[contains(text(), 'Admin First Name')]/../..//td[2]/input";
	public static String address_xpath="//*[contains(text(), 'Address')]/../..//td[2]/textarea";
	public static String state_xpath="//*[contains(text(), 'State')]/../..//td[2]/input";
	public static String city_xpath="//*[contains(text(), 'City')]/../..//td[2]/input";
	public static String street_xpath="//*[contains(text(), 'Street')]/../..//td[2]/input";
	public static String pincode_xpath="//*[contains(text(), 'Zip Code/Postal Code')]/../..//td[2]/input";
	
	public static String secondName_id="//*[contains(text(), 'Admin Last Name')]/../..//td[2]/input";
	public static String email_id="//*[contains(text(), 'Admin Email')]/../..//td[2]/input";
	public static String firstNameper_id="//*[contains(text(), 'First Name')]/../..//td[2]/input";
	
	public static String secondNameper_id="//*[contains(text(), 'Last Name')]/../..//td[2]/input";
	public static String emailper_id="//*[contains(text(), 'Email')]/../..//td[2]/input";
	public static String succesfull_xpath="//*[contains(text(), 'Successfully Completed the operation.')]";
	
	//TNC
	public static String addTNCFirstNameid="InstitutionDetailsBean.firstName";
	public static String addTNCLastNameid="InstitutionDetailsBean.lastName";
	public static String addTNCEmailid="InstitutionDetailsBean.email";
	public static String addPhoneid="InstitutionDetailsBean.phone";
	
	//Article Select
	
	public static String SlotLicensesection_className = "slotLicenseConsumption";
	public static String SlotLicenseConfirm_xpath = "(//div[@class='clearfix'])[2]/input[@value='CONFIRM']";
	public static String SlotLicenseConfirmMob_xpath = "(//div[@class='clearfix'])/input[@value='CONFIRM']";
	
	//AS2
	public static String SecuritySection_xpath = "//*[@id='security-information-section']/div[@class='clik-link']//div[@class='re-place arrow-down']";
	public static String ChangePassword_id = "change-password";
	public static String OldPassword_id = "existing-password";
	public static String NewPassword1_id = "new-password";
	public static String NewPassword2_id = "repeat-change-password";
	public static String SavePassword_id = "save_security";
	public static String ConfirmPopUp_xpath = "//*[@class='btn btn-white']";
	public static String loggedUser_id = "indivLogin";
	public static String MyAccount_xpath = "//a[contains(text(), 'My account')]";
	public static String ChangePWD_xpath = "//*[.='change password']";
	public static String oldPasswordField_xpath = ".//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-old']";
	public static String newPasswordField_xpath = ".//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-new']";
	public static String changePassSubmit_xpath = "//*[@class='popup change-password-drawer']//*[@class='button primary submit']";

	public static String updateEmailArrow_xpath=".//*[@id='email-information-section']/div[1]/div[1]/div[2]/div/img";
	public static String editButton_xpath=".//*[@id='editEmailInfo']";
	public static String primaryEmailField_xpath=".//*[@id='Primary_id']";
    public static String saveButton_xpath=".//*[@id='saveEmailinfo']";
    public static String closeModalWindow_xpath=".//*[@id='dialog-modal']/div/div[2]/div/div/div[2]/div[1]/button";
	public static String achOldPass_xpath = ".//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-old']";
	public static String achNewPass_xpath = ".//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-new']";
	public static String achSubmitButton_xpath =".//*[@id='pb-page-content']/div/div[5]/div/div[2]/div[1]/form/input[2]";

	
	/*Application Name= JQA QA Gateway 
	 * Page Name= JQA QA Page
	 Designed by Janmejaya Sahu*/
			
	public static String JQA_QA_Loginpage_xpath="//h1[contains(text(),'Journals QA')]";
	public static String JQA_QA_username_xpath="//input[@id='username']";
	public static String JQA_QA_password_xpath="//input[@id='password']";
	public static String JQA_QA_btnlogin_xpath="//input[@id='btnLogin']";
	public static String JQA_QA_Homepage_xpath="//p[@id='userNameLabel']";
	public static String JQA_QA_uploadPackage_xpath="//input[@id='uploadedFile']";
	public static String upload_Successful_xpath="//p[contains(text(),'is successfully uploaded')]";
	public static String btn_Upload_xpath="//input[@id='uploadFilebtn']";
	public static String Upload_Status_xpath="(//a[contains(text(),'CBIN_AA_CBIN10940.zip')]//following::td[1])[1]";
	public static String delivered_Status_xpath="//tr[@class='ng-scope']//td[4]";
	public static String chkenforceVisualQACheckBox_xpath="//input[@id='enforceVisualQACheckBox']";
	/*Application Name= JQA UI  
	 * Page Name= JQA UI Page
	 Designed by Janmejaya Sahu*/
	
	public static String tab_Admin_xpath="//span[text()='Admin']/..";
	public static String subtab_ManageContent_xpath="//*[@id='csAdminSearchFunLi']/a/span[contains(text(),'Manage Content')]";
	//public static String subtab_ManageContent_xpath="//span[text()='Manage Content']/..";
	public static String search_Level_xpath="//td[text()='Search Level']";
	public static String txt_JournalId_xpath="//input[@id='jcod']";
	public static String btn_Search_xpath="//input[@id='search']";
	public static String search_Resulttable_xpath="//table[@class='jtable']";
	public static String article_DOI_xpath="//span[text()='Article DOI']/..";
	public static String tabCADashboard_xpath="//span[text()='CA Dashboard']";
	public static String tabpreviewContent_xpath="//button[@id='previewContent']";
	public static String tabpreviewContent1_xpath="//button[@id='previewContent1']";
	public static String tabPreviewContent_PubArticle_xpath="//button[@id='previewContent1']";
	public static String btnWarningClose_xpath="(//button[@title='close'])[1]";
	public static String chkbox_SelectAll_xpath="//input[@id='selectAllId']";
	public static String btn_viewInPlatform_xpath="//input[@id='viewPlatform']";
	public static String btn_viewInPlatformPubArticles_xpath="//input[@id='viewPlatformPublished']";
	public static String btnApprove_xpath="//div[@id='headerBtns']/input[@id='approveBtnId']";
	public static String popup_Confirmapprove_xpath="//div[@id='confirmApproveRejectPopup']";
	public static String btnOK_Confirmapprove_xpath="//input[@id='confirmApproveRejectPopupOk']";
	public static String lnk_ViewFullSize_xpath="//td//a[text()='View Full Size Image']";
	public static String journalListarticle_xpath="//li//div[@id='journal-list']";
	public static String btnSetEmbargo_xpath="//input[@id='setEmbargo']";
	public static String embargoForm_xpath="//div[@id='embargoForm']";
	public static String iconCalender_xpath="//img[@src='/img/calendar.gif']";
	public static String btn_ConfirmDate_xpath="//input[@id='edSubmit']";
	public static String dateReflected_xpath="//td[@id='embargoDateValueTd']";
	public static String tab_PublishedArticles_xpath="(//span[text()='Published Articles'])[1]";
	public static String txt_Journalid_xpath="//input[@id='jid']";
	public static String btnSearch_xpath="//button[@id='filter']";
	public static String btnSearchJrnalId_ActLog_xpath ="//input[@id='jidevent']";
	public static String ActivityLog_xpath ="//span[text()='Activity Log']";
	public static String txtEmbargoDate_xpath ="//input[@id='embargoDate']";
	
	/*Application Name= DSS QA 
	 * Page Name= DSS QA Page
	 Designed by Janmejaya Sahu*/
	
	public static String DSS_QA_Username_xpath="//input[@name='j_username']";
	public static String DSS_QA_Password_xpath="//input[@name='j_password']";
	public static String DSS_QA_btnlogin_xpath="//input[@type='submit']";
	public static String menu_Monitor_xpath="//a[text()='MONITOR']";
	public static String submenu_SearchContent_xpath="//a[text()='Search Content']/..";
	public static String searchContent_page_xpath="//h1[text()='Search Content']";
	public static String txt_ContentId_xpath="//td[text()='Content Id']/following-sibling::td/input";
	public static String btn_SearchId_xpath="//input[@type='button']";
	//public static String table_SearchContentId_xpath="//table[@id='striped']";
	public static String table_SearchContentId_xpath="//*[@id='striped']/tbody/tr[2]/td[1]";
	public static String lnk_AddtoDelivery_xpath="//a[text()='Add to delivery']";
	public static String successfulPopupmsg_xpath="//div[@class='message ng-binding']";
	public static String menu_Delivery_xpath="//a[text()='DELIVER']";
	public static String submenu_ManualDelivery_xpath="//a[text()='Manual Delivery']";
	public static String deliverContent_Page_xpath="//h1[text()='Deliver Content']";
	public static String txt_ContentType_xpath="//select[@class='form-control ng-pristine ng-untouched ng-valid']";
	public static String chk_literatumAA_xpath="//td[@class='ng-binding'][contains(text(),'LIT_Migration')]/following-sibling::td//div[1]//input";
	public static String chk_Literatum_AA_Test_xpath="//td[@class='ng-binding'][contains(text(),'LIT_Migration')]/following-sibling::td//div[3]//input";
	public static String chk_Literatum_AA_EVStag_xpath="//td[@class='ng-binding'][contains(text(),'LIT_Migration')]/following-sibling::td//div[2]//input";
	public static String chk_Literatum_Issue_Test_xpath="//td[@class='ng-binding'][contains(text(),'LIT_Migration')]/following-sibling::td//div[1]//input";
	public static String chk_LiteratumIssueTest_xpath="//td[@class='ng-binding'][contains(text(),'LIT_Migration')]/following-sibling::td//div[4]//input";
	public static String issueDoi_xpath="(//td[text()='ppmaji']/following::td[contains(text(),'issue')])[1]";
	public static String radbtn_Showlicense_xpath="//div[@class='panel-heading']//div[@class='material-switch pull-right']";
	public static String btn_deliver_xpath="//input[@id='deliverBtn']";
	public static String radbtn_UseLicense_xpath="(//li[@class='list-group-item']//div[@class='material-switch pull-right'])[2]";
	public static String radbtn_ShowImmediately_xpath="(//li[@class='list-group-item']//div[@class='material-switch pull-right'])[3]";
	public static String submenu_BulkDeliveries_xpath="//li//a[text()='Bulk Deliveries']";
	public static String bulkDeliveries_Page_xpath="//h1[text()='Bulk Deliveries']";
	public static String lnk_View_xpath ="(//td[text()='ppmaji']/ancestor::tr//a[text()='View'])[1]";
	public static String lnk_ViewTrackBulkDeliveries_xpath ="(//div//a[text()='View'])[1]";
	public static String lnkreceived_xpath ="//a[text()='received/']";
	public static String ArticlesTab_xpath ="//a[@id='ui-id-23']";
	public static String addArticle_xpath ="//button[text()='Add Article']";
	public static String lnk_ViewParent_xpath="//a[text()='View Parent']";
	
	
	/*Application Name= Wiley Online Library 
	 * Page Name= Wiley Online Page
	 Designed by Janmejaya Sahu*/
	
	public static String lnkLoginRegister_xpath ="//a//span[text()='Login / Register']";
	public static String tabActivityLog_xpath ="(//*[text()='Activity Log'])[1]";
	public static String LiveFeed_xpath ="(//*[text()='Live Feed']/..)[1]";
	
	//Literatum Front end(check for the article present with DOI)
		public static String articlenotfound_xpath ="//h1[contains(text(),'Error')]";  
		
	/*Application Name= Content Admin 
	 * Page Name= Content Admin 
	 * Designed by Janmejaya Sahu  */
	
	public static String CONTENT_ADMIN_Username_xpath ="(//input[@id='login'])[1]";
	public static String CONTENT_ADMIN_Password_xpath ="(//input[@id='password'])[1]";
	public static String CONTENT_ADMIN_btnlogin_xpath ="(//input[@value='Log In'])[1]";
	public static String tab_items_xpath ="//a[text()='Items']";
	public static String txt_searchDOI_xpath ="//input[@id='articlesTable_doiFilter']";
	public static String btn_refreshview_xpath ="//a[text()='Refresh View']";
	public static String tab_processingQueue_xpath ="//li[contains(@id,'processingQueue')]//a[text()='Processing Queue']";
	public static String txt_contentmatches_xpath ="//input[@id='contentMatches']";
	public static String lnk_ViewDetails_xpath ="//a[text()='View Details']";
	public static String published_xpath ="//td[text()='Published']/following-sibling::td[2]";
	public static String status_xpath ="//td[text()='Status']/following-sibling::td[2]";
	public static String Action_Category_xpath ="//*[@id='actionSel']";
	public static String Action_subtask_xpath ="//*[@id='taskActions']";
	
	public static String tab_Groups_xpath ="//a[text()='Groups']";
	public static String txt_DOI_xpath ="//input[@id='issuesTable_doiFilter']";
	public static String opt_Delete_xpath ="(//a[text()='Delete'])[1]";
	public static String deleteIssue_Dialogbox_xpath ="//div//span[@id='ui-id-10']";
	public static String btn_ConfirmDelGroup_xpath ="//button[@id='btn-confirm-delete-group']";
	public static String issueTable_xpath ="//table[@id='issuesTable']";
	public static String actiontab_xpath ="(//button[text()='Actions'])[1]";
	public static String actionList_xpath ="//div[@class='dropdown-action-menu dropdown-content dropdown-top ui-state-default show']";
	public static String Production_xpath ="//td[text()='Production']";
	public static String deleteArticle_Dialogbox_xpath ="//div[@id='delete-item-dialog']";
	public static String btn_ConfirmDelItem_xpath ="//button[@id='btn-confirm-delete-item']";
	public static String del_Schedule_Dialogbox_xpath ="//div[@id='delete-result-dialog']";
	public static String btn_Ok_delScheduleDialog_xpath ="//div[@id='delete-result-dialog']/following-sibling::div//div//button";
	public static String leftPanel_CompltdStatus_xpath ="//div[@id='leftPanelContainer']//following::span[text()='Completed']";
	public static String statusFull_xpath ="//td[text()='Status']/following-sibling::td[text()='full']";
	public static String View_In_Browser_xpath ="//a[contains(text(),'[View in Browser]')]";
	
//<<<<<<< .mine
	//public static String statusComplete_xpath ="//td[text()='Status']/following-sibling::td[text()='complete']";
	public static String statusEV_xpath="//td[text()='Status']/following-sibling::td[text()='earlyview']";
	public static String statusAA_xpath="//td[text()='Status']/following-sibling::td[text()='accepted']";
//||||||| .r426
//=======
	public static String statusComplete_xpath ="//td[text()='Status']/following-sibling::td[text()='complete']";
	public static String statusearlyview_xpath ="//td[text()='Status']/following-sibling::td[text()='earlyview']";
//>>>>>>> .r441
	public static String publishedNo_xpath ="//td[text()='Published']/following-sibling::td[text()='no']";
	public static String publishedYes_xpath ="//td[text()='Published']/following-sibling::td[text()='yes']";
	public static String areaTextbox_xpath ="//tr[@class='odd']//td[2]";
	
	public static String workFlowState_xpath ="//select[@id='issuesTable_workflowStateFilter']";
	public static String opt_Move_xpath ="(//a[text()='Move'])[1]";
	public static String moveIssueDialogbox_xpath ="//span[@id='ui-id-14']";
	public static String toAreaDropdwn_xpath ="//select[@id='targetAreaSelector']";
	public static String moveWithDropdwn_xpath ="//select[@id='targetContentSelector']";
	public static String moveContentDropdwn_xpath ="//select[@id='scheduleTimeSel']";
	public static String btn_Move_xpath ="//button[@id='btn-move-group']";
	public static String area_Staging_xpath ="//td[text()='Staging']";
	public static String area_Live_xpath ="//td[text()='Live']";
	public static String moveScheduleDialog_xpath ="//span[text()='Move Schedule Dialog']";
	public static String btnOK_moveScheduleDialog_xpath ="(//div[@class='ui-dialog-buttonset']/following::button[text()='Ok'])[2]";

	public static String CMS_PublicationStatus_xpath ="//span[text()='CMS Publication Processing']/following::td[2]";
	public static String contentGenerationStatus_xpath ="//span[text()='Content Generation']/following::td[2]";
	public static String contentBundleLinkingStatus_xpath ="//span[text()='Content Bundle Linking']/following::td[2]";
	public static String CMSSendPublicationStatus_xpath ="//span[text()='CMS Send Publication Processed Alerts']/following::td[2]";
	public static String atyponActionStatus_xpath ="//span[text()='urn:atypon:action:SendPublicationEvents']/following::td[2]";
	//public static String text_ContentSubmission_xpath ="(//td[text()='Content Submission'])[1]";
	public static String chkboxJrnalId_PubArticles_xpath ="(//div[@id='panelArticleListContainer']//following::tr[1]/following::input)[1]";
	public static String authorManuscript_PubArticles_xpath ="//li[@id='authorManuscriptid']";
	public static String contentGenerationMessage_xpath ="//span[text()='Content Generation']/following::td[3]";
	public static String contentGenerationProcessingMessage_xpath ="//span[text()='Content Generation']/following::td[7]/a[@class='button']";
	public static String contentGenerationError_type_xpath ="//tr[4]/td[2]/span";
	public static String CMS_Publication_deposit_Message_xpath ="//span[text()='CMS Publication Deposit']/following::td[7]/a[@class='button']";
	public static String Interface_generation_xpath ="//span[text()='Interface Generation']/following::td[7]/a[@class='button']";

	public static String toAreaDropdwninArticle_xpath ="//select[@id='targetItemAreaSelector']";
	public static String moveContentDropdwninArticle_xpath ="//select[@id='moveArticleTimeSel']";
	public static String btnMoveArticle_xpath ="//button[@id='btn-move-item']";
	public static String moveArticleDialogbox_xpath ="(//span[text()='Move article Dialog'])[2]";
	public static String confirmMoveArticleDialogbox_xpath ="//span[text()='Move Schedule Dialog']";
	public static String btnOk_ArticleDialogbox_xpath ="(//button[text()='Ok'])[3]";
	
	//Miscellaneous Latest
	
	public static String LitAppDOIClick_xpath=".//*[@id='pb-page-content']/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/ul/li/div/h2/span/a";
	public static String LitAppScroll_xpath=".//*[@id='pane-67065c09-4a88-49cd-934c-ac707951d35c0']/form/div/input[1]";
	public static String LitAppLoginLink_xpath=".//*[@id='pb-page-content']/div/div[1]/header/div/div[2]/div/div/div/div[3]/div/div/a/span[2]";
    public static String LitAppUserID_xpath=".//*[@id='login']";
    public static String LitAppPassword_xpath=".//*[@id='password']";
    public static String LitAppLoginButton_xpath=".//*[@id='pb-page-content']/div/div[4]/div/div[2]/div[2]/form/div[4]/div/input";
    public static String LitAppSearchField_xpath=".//*[@id='searchField1']";
    public static String LitAppSearchButton_xpath=".//*[@id='pb-page-content']/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/form/button";
    public static String LitAppItemsFound_xpath ="//*[@id='pb-page-content']//span[@class='result__count'][1]";		
	
    
    public static String loginlink_xpath="//a/span[2]";
	public static String loginusernameLocator_xpath="//*[@id='login']";
	public static String loginpasswordLocator_xpath="//*[@id='password']";
	public static String loginbutton_xpath="//*[@id='pb-page-content']/div/div[4]/div/div[2]/div[2]/form/div[4]/div/input";
	public static String invalidloginmsg_xpath="//*[@id='pb-page-content']/div/div[4]/div/div[2]/div[2]/div[1]";
	public static String instAdminName_xpath="//*[@id='indivLogin']/span[2]";
	public static String instAdministration_xpath=".//*[@id='pb-page-content']//ul/li[2]/a";
	
	public static String ipRangelocator_name="ipRange0";
	public static String ipRangedesclocator_name="description0";
	public static String submitIPRangeChanges_xpath="//*[@id='institutionMultiIpChange']/div[2]/input[1]";
	public static String ipRangedetaillocator_xpath="//*[@id='pt1:_d_reg:region1:1:r5:0:r2:1:r2:0:_xgc_2:_xgtb_0:0:_xgc_5::content']";
	public static String ipRangetablelocator_xpath="//*[@id='pt1:_d_reg:region1:1:r5:0:pc1:t1::db']/table/tbody/tr[2]/td[1]";
	public static String myAccountlocator_xpath="//ul/li[1]/a";
	public static String changePWDlocator_xpath="//*[@id='personalInformationForm']/div[1]/section[2]/div[2]/div/div[2]/div/div[2]/a";
	public static String oldPWDlocator_xpath="//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-old']";
	public static String newPWDlocator_xpath="//*[@id='a589574e-bb98-4c6e-8fed-67365ff05357-new']";
	public static String submitPWDbuttonlocator_xpath="//*[@id='pb-page-content']/div/div[5]/div/div[2]/div[1]/form/input[2]";
	public static String PWDwindowclose_xpath="//*[@id='pb-page-content']/div/div[5]/div/a";
	public static String PWDchangemsg_xpath="//*[@id='pb-page-content']/div/div[5]/div/div[2]/div[2]/h2";
	public static String logoutbutton_xpath="//*[@id='pb-page-content']/div/div[1]/header/div/div[2]/div/div/div[3]/div[2]/div[2]/div[1]/ul/li[3]/a";
	public static String searchboxlocator_xpath="//*[@id='searchField1']";
	public static String searchbuttonlocator_xpath="//*[@id='pb-page-content']/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/form/button";
	public static String noofsearchfoundlocator_xpath="//*[@id='pb-page-content']/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/span[1]";
	public static String searchedDOIlocator_xpath="//*[@id='pb-page-content']/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/span[3]";
	public static String contentlinklocator_xpath="//*[@id='pb-page-content']/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/ul/li/div/h2/span/a";
	public static String adminemaillocator_xpath="//*[@id='fakeEmail']";
	public static String admincnfemaillocator_xpath="//*[@id='login.email2']";
	public static String updatebuttonlocator_xpath="//*[@id='personalInformationForm']/div[2]/input";
	public static String duplicateEmailmsg_xpath="//*[@id='personalInformationForm']/div[2]/section[2]/div[2]/div/div[1]/div[1]/div";
			
	
	
	//Duplicate Email Latest
	
	public static String LitWebadminUsername_xpath=".//*[@id='login']";
	public static String LitWebadminPassword_xpath=".//*[@id='password']";
	public static String LitWebadminLoginButton_xpath=".//*[@id='pb-page-content']/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[1]/form/div[4]/div/input";
	public static String LitWebadminAdminLink_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div/span/span[1]";
	public static String LitWebadminIdentitiesLink_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[3]/div/div/div[3]/div/div[1]/div/span/span[1]";
	public static String LitWebadminPersonuserLink_xpath=".//*[@id='gwt-uid-9']/div";
	public static String LitWebadminEmail_xpath=".//*[@id='gwt-uid-40']";
	public static String LitWebadminStatescroll_xpath=".//*[@id='gwt-uid-58']";
	public static String LitWebadminSearchbutton_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div[1]/div/div";
	public static String LitWebadminPasswordscroll_xpath=".//*[@id='gwt-uid-47']";
	public static String LitWebadminEmailedit_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[9]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]/div";
	public static String LitWebadminComment_xpath=".//*[@id='gwt-uid-55']";
	public static String LitWebadminSearchedemail_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[9]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]";
	public static String LitWebadminEditbutton_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[9]/div/div[2]/div/div/div/div[2]/div/div/div[3]/div/div[1]/div";
	public static String LitWebadminEditemail_xpath=".//*[@id='gwt-uid-249']";
	public static String LitWebadminOkbutton_xpath=".//*[@id='webadmin-717083525-overlays']/div[3]/div/div/div[3]/div/div/div[3]/div/div[1]/div";
	public static String LitWebadminCustscroll_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[11]/div/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]/div";
	public static String LitWebadminUpdatebutton_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div[1]/div/div";
	public static String LitWebadminFinalConfirm_xpath=".//*[@id='webadmin-717083525-overlays']/div[3]/div/div/div[3]/div/div/div[3]/div/div[1]/div";
	public static String LitWebadminSearchLink_xpath=".//*[@id='gwt-uid-8']/div";
	public static String LitWebadminPublicId_xpath=".//*[@id='gwt-uid-3']";
	public static String LitWebadminSearchButton_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div";
	public static String LitWebadminPersonUserClick_xpath =".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[1]/div";
	public static String LitWebadminDetailButton_xpath=".//*[@id='webadmin-717083525']/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div";

	public static String adminEmaillocator_xpath="//*[@id='pt1:_d_reg:region1:1:plam34']/td[2]";
	public static String Attributestablocator_xpath="//*[@id='pt1:_d_reg:region1:1:sdi1::disAcr']";
	public static String changePWDtablocator_xpath="//*[@id='pt1:_d_reg:region1:1:cil6']/span";
	public static String manualchangelocator_xpath="//*[@id='pt1:_diags:dgTfRg:1:sbr1::content']";
	public static String newPassword_xpath="//*[@id='pt1:_diags:dgTfRg:1:it2::content']";
	public static String confirmpassword_xpath="//*[@id='pt1:_diags:dgTfRg:1:it22::content']";
	public static String resetPWDbtn_xpath="//*[@id='pt1:_diags:dgTfRg:1:cb1']";
	
	
	
}










