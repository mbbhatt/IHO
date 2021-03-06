//
//  CreditDetailsViewController.m
//  IHO
//
//  Created by Cynosure on 4/13/14.
//  Copyright (c) 2014 asu. All rights reserved.
//

#import "CreditDetailsViewController.h"
#import "MainViewController.h"

@interface CreditDetailsViewController ()

@end

@implementation CreditDetailsViewController
@synthesize  creditText;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    bool ipad = ([[UIDevice currentDevice]userInterfaceIdiom ] == UIUserInterfaceIdiomPad);
    // Do any additional setup after loading the view.
    //menubar specifications
    self.navigationController.navigationBar.titleTextAttributes = @{NSForegroundColorAttributeName : [UIColor whiteColor]};

    
    //Declare the webview to display content
    NSString *path = [[NSBundle mainBundle] pathForResource:@"CreditDetails" ofType:@"html"];
    if (path){
        
        NSData *data=[NSData dataWithContentsOfFile:path];
        [creditText loadData:data MIMEType:@"text/html" textEncodingName:@"convert"  baseURL:nil];
        creditText.scrollView.scrollEnabled= TRUE;
        [creditText setFrame:CGRectMake(0, 0, self.view.frame.size.width, self.view.frame.size.height)];
        [self.view addSubview:creditText];
    }
    self.navigationController.toolbarHidden = NO;
    [self.navigationController.toolbar setTranslucent:NO];
    [UIFont fontWithName:@"Arial-MT" size:15];
    UIBarButtonItem *customItem1 = [[UIBarButtonItem alloc]
                                    initWithTitle:nil style:UIBarButtonItemStyleBordered
                                    target:self action:nil];
    
    UIBarButtonItem *customItem2 = [[UIBarButtonItem alloc]
                                    initWithTitle:@"@IHO ASU 2014" style:UIBarButtonItemStyleDone
                                    target:self action:nil];
    customItem2.tintColor = [UIColor colorWithWhite:1 alpha:1];
    
    
    if(!ipad){
        
        [customItem1 setWidth:55];
        [customItem2 setWidth:90];
        
    }
    else{
        
    }
    
    
    NSArray *toolbarItems = [NSArray arrayWithObjects:
                             customItem1,customItem2,nil];
    
    self.toolbarItems = toolbarItems;

    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
