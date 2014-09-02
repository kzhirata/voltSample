#!/bin/sh

csvloader -f ./data/visitor.csv visitor && csvloader -f ./data/mail.csv mailhistory && csvloader -f ./data/tracking.csv trackinghistory

