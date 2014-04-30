#! /bin/sh

keytool -genkey -alias soapuiSSL -keyalg RSA -keystore sandpit.keystore \
-storepass sandpit \
-dname "cn=John Doe, ou=soapui, o=dumitruc, c=GB" \
-keypass sandpit