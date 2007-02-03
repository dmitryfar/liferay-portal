/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.service.http;

import com.liferay.portal.service.CompanyServiceUtil;

import org.json.JSONObject;

/**
 * <a href="CompanyServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CompanyServiceJSON {
	public static JSONObject updateCompany(java.lang.String companyId,
		java.lang.String portalURL, java.lang.String homeURL,
		java.lang.String mx, java.lang.String name, java.lang.String legalName,
		java.lang.String legalId, java.lang.String legalType,
		java.lang.String sicCode, java.lang.String tickerSymbol,
		java.lang.String industry, java.lang.String type, java.lang.String size)
		throws com.liferay.portal.SystemException, 
			com.liferay.portal.PortalException, java.rmi.RemoteException {
		com.liferay.portal.model.Company returnValue = CompanyServiceUtil.updateCompany(companyId,
				portalURL, homeURL, mx, name, legalName, legalId, legalType,
				sicCode, tickerSymbol, industry, type, size);

		return CompanyJSONSerializer.toJSONObject(returnValue);
	}

	public static void updateDisplay(java.lang.String companyId,
		java.lang.String languageId, java.lang.String timeZoneId,
		java.lang.String resolution)
		throws com.liferay.portal.SystemException, 
			com.liferay.portal.PortalException, java.rmi.RemoteException {
		CompanyServiceUtil.updateDisplay(companyId, languageId, timeZoneId,
			resolution);
	}

	public static void updateSecurity(java.lang.String companyId,
		java.lang.String authType, boolean autoLogin, boolean sendPassword,
		boolean strangers, boolean communityLogo)
		throws com.liferay.portal.SystemException, 
			com.liferay.portal.PortalException, java.rmi.RemoteException {
		CompanyServiceUtil.updateSecurity(companyId, authType, autoLogin,
			sendPassword, strangers, communityLogo);
	}
}