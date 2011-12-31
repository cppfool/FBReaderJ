/*
 * Copyright (C) 2009-2012 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.preferences;

import org.geometerplus.zlibrary.core.options.ZLStringOption;
import org.geometerplus.zlibrary.core.resources.ZLResource;

import android.content.Context;

class ZLStringOptionPreference extends ZLStringPreference {
	private final ZLStringOption myOption;
	private ZLOptionHandler myHandler = null;

	ZLStringOptionPreference(Context context, ZLStringOption option, ZLResource rootResource, String resourceKey) {
		super(context, rootResource, resourceKey);
		myOption = option;
		setValue(myOption.getValue());
	}

	ZLStringOptionPreference(Context context, ZLStringOption option, ZLResource rootResource, String resourceKey, ZLOptionHandler handler) {
		super(context, rootResource, resourceKey);
		myOption = option;
		setValue(myOption.getValue());
		myHandler = handler;
	}

	@Override
	protected void onDialogClosed(boolean result) {
		super.onDialogClosed(result);
		myOption.setValue(getValue());
	}

	/**
	 * Handles option callback
	 */
	@Override
	protected void onDialogClosed(boolean result) {
		if (result) {
			if (myHandler != null)
				myHandler.onDialogValidated(getEditText().getText().toString());
		}
		super.onDialogClosed(result);
	}

	public ZLStringOption getOption() {
		return myOption;
	}
}
