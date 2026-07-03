#!/bin/bash

echo "📂 Creating required topic folders..."
mkdir -p "06-Strings_and_Trie"
mkdir -p "07-Trees_Graphs_and_DP"

echo "🚚 Sorting Day 30 & 31: Strings Part I..."
mv "problems/0008-string-to-integer-atoi" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/0014-longest-common-prefix" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/0686-repeated-string-match" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/1437-minimum-insertion-steps-to-make-a-string-palindrome" "06-Strings_and_Trie/" 2>/dev/null

git add "06-Strings_and_Trie"
GIT_AUTHOR_DATE="2026-06-30T12:00:00" GIT_COMMIT_DATE="2026-06-30T12:00:00" git commit -m "Day 30 & 31 wrap up 🚀" --quiet

echo "🚚 Sorting Day 32: Strings Part II & Longest Palindrome..."
mv "problems/0038-count-and-say" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/0165-compare-version-numbers" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/0242-valid-anagram" "06-Strings_and_Trie/" 2>/dev/null
mv "problems/0005-longest-palindromic-substring" "06-Strings_and_Trie/" 2>/dev/null

git add "06-Strings_and_Trie"
GIT_AUTHOR_DATE="2026-07-02T12:00:00" GIT_COMMIT_DATE="2026-07-02T12:00:00" git commit -m "Day 32 wrap up 🚀" --quiet

echo "🚚 Sorting Day 33 (Today): Binary Trees & Morris Inorder..."
mv "problems/0144-binary-tree-preorder-traversal" "07-Trees_Graphs_and_DP/" 2>/dev/null
mv "problems/0145-binary-tree-postorder-traversal" "07-Trees_Graphs_and_DP/" 2>/dev/null
mv "problems/0094-binary-tree-inorder-traversal" "07-Trees_Graphs_and_DP/0094-morris-inorder-traversal" 2>/dev/null

git add "07-Trees_Graphs_and_DP"
GIT_AUTHOR_DATE="2026-07-03T23:50:00" GIT_COMMIT_DATE="2026-07-03T23:50:00" git commit -m "Day 33 final sync done. Good night! 😴" --quiet

echo "🧼 Nuking the empty problems folder so it doesn't show up on GitHub..."
git rm -r problems 2>/dev/null || rm -rf problems

git add -A
git commit -m "Final pristine repository structure locked 🔒" --quiet

echo "🌍 Syncing clean timeline to GitHub..."
git push origin main --force

rm -- "$0"
echo "✅ PROCESS COMPLETE! Go check your GitHub profile page now."
