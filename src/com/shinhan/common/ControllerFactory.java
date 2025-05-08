package com.shinhan.common;


import com.shinhan.common.InsertController;
import com.shinhan.common.SelectController;


public class ControllerFactory {
	public static CommonControllerInterface make(String business) {
		CommonControllerInterface controller = null;
		switch(business) {
		case "insert" -> {controller = new InsertController();}
		case "select" -> {controller = new SelectController();}
		case "update" -> {controller = new UpdateController();}
//		case "delete" -> {controller = new DeleteController();}
		}
		return controller;
	}
}
