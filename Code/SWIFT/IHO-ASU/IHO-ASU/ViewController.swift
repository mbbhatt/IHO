//
//  ViewController.swift
//  IHO-ASU
//
//  Created by Sweta Singhal on 2/7/17.
//  Copyright © 2017 Sweta Singhal. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var iho_footer: UIBarButtonItem!
    @IBOutlet weak var donate: UIButton!
    @IBOutlet weak var about: UIButton!
    @IBOutlet weak var gallery: UIButton!
    @IBOutlet weak var connect: UIButton!
    @IBOutlet weak var field: UIButton!
    @IBOutlet weak var news: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // button sytle
        news.layer.cornerRadius = 15
        about.layer.cornerRadius = 15
        donate.layer.cornerRadius = 15
        gallery.layer.cornerRadius = 15
        connect.layer.cornerRadius = 15
        field.layer.cornerRadius = 15
        
        // ASU LOGO at navigation bar
        var imageView: UIImageView?
        var ipad: Bool = (UIDevice.current.userInterfaceIdiom == .pad)
        //var htmlpath: String? = nil
        if !ipad {
            imageView = UIImageView(frame: CGRect(x: CGFloat(0), y: CGFloat(0), width: CGFloat(self.navigationController!.navigationBar.frame.size.width / 1.75), height: CGFloat(self.navigationController!.navigationBar.frame.size.height / 1.25)))
        }
        else {
            imageView = UIImageView(frame: CGRect(x: CGFloat(0), y: CGFloat(0), width: CGFloat(self.navigationController!.navigationBar.frame.size.width / 2.5), height: CGFloat(self.navigationController!.navigationBar.frame.size.height / 1.5)))
        }
        var logoView = UIView(frame: CGRect(x: CGFloat(0), y: CGFloat(0), width: CGFloat((imageView?.frame.size.width)!), height: CGFloat((imageView?.frame.size.height)!)))
        logoView.addSubview(imageView!)
        self.navigationItem.titleView = logoView
        imageView?.image = UIImage(named: "asu_logo.jpg")
        
        
        //tab bar
        if let font = UIFont(name: "ASU IHO 2017", size: 15) {
            iho_footer.setTitleTextAttributes([NSFontAttributeName:font], for: .normal)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

