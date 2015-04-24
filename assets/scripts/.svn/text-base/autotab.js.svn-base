// ===================================================================
// Author: Matt Kruse <matt@mattkruse.com>
// WWW: http://www.mattkruse.com/
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download. 
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================

// -------------------------------------------------------------------
// TabNext()
// Function to auto-tab phone field
// Arguments:
//   obj :  The input object (this)
//   event: Either 'up' or 'down' depending on the keypress event
//   len  : Max length of field - tab when input reaches this length
//   next_field: input object to get focus after this one
// -------------------------------------------------------------------
var phone_field_length=0;
function TabNext(obj,event,len,next_field) {
	if (event == "down") {
		phone_field_length=obj.value.length;
		}
	else if (event == "up") {
		if (obj.value.length != phone_field_length) {
			phone_field_length=obj.value.length;
			if (phone_field_length == len) {
				next_field.focus();
				}
			}
		}
	}
