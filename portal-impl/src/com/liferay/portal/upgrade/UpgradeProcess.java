/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.upgrade;

import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.tools.sql.DBUtil;

import java.io.IOException;

import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * <a href="UpgradeProcess.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public abstract class UpgradeProcess {

	public UpgradeProcess() {
	}

	public int getThreshold() {

		// This upgrade process will only run if the build number is larger than
		// the returned threshold value. Return 0 to always run this upgrade
		// process.

		return 0;
	}

	public boolean isSupportsAlterColumnName() {
		return DBUtil.getInstance().isSupportsAlterColumnName();
	}

	public boolean isSupportsAlterColumnType() {
		return DBUtil.getInstance().isSupportsAlterColumnType();
	}

	public boolean isSupportsStringCaseSensitiveQuery() {
		return DBUtil.getInstance().isSupportsStringCaseSensitiveQuery();
	}

	public boolean isSupportsUpdateWithInnerJoin() {
		return DBUtil.getInstance().isSupportsUpdateWithInnerJoin();
	}

	public void runSQL(String template) throws IOException, SQLException {
		DBUtil.getInstance().runSQL(template);
	}

	public void runSQL(String[] templates) throws IOException, SQLException {
		DBUtil.getInstance().runSQL(templates);
	}

	public void runSQLTemplate(String path)
		throws IOException, NamingException, SQLException {

		DBUtil.getInstance().runSQLTemplate(path);
	}

	public void runSQLTemplate(String path, boolean failOnError)
		throws IOException, NamingException, SQLException {

		DBUtil.getInstance().runSQLTemplate(path, failOnError);
	}

	public void upgrade() throws UpgradeException {
		try {
			doUpgrade();
		}
		catch (Exception e) {
			throw new UpgradeException(e);
		}
	}

	public void upgrade(Class<?> upgradeProcessClass)
		throws UpgradeException {

		UpgradeProcess upgradeProcess = (UpgradeProcess)InstancePool.get(
			upgradeProcessClass.getName());

		upgradeProcess.upgrade();
	}

	public void upgrade(UpgradeProcess upgradeProcess)
		throws UpgradeException {

		upgradeProcess.upgrade();
	}

	protected void doUpgrade() throws Exception {
	}

}